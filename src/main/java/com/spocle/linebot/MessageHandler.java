package com.spocle.linebot;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.JoinEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.spocle.domain.model.entity.Team;
import com.spocle.domain.service.TeamService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import retrofit2.Response;

import java.util.Collections;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by h.ono on 2017/04/08.
 */
@LineMessageHandler
@Service
public class MessageHandler {

    private final TemplateMessageHandler templateMessageHandler;

    @Autowired
    private TeamService teamService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${line.bot.channel-token}")
    private String channelToken;

    public MessageHandler(TemplateMessageHandler templateMessageHandler) {
        super();
        this.templateMessageHandler = templateMessageHandler;
    }


    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
		System.out.println("event: " + event);

		String str = event.getMessage().getText();

//		// RedisからコードをもとにチームIDを取得
        Object val = redisTemplate.opsForValue().get(str);


        if(val == null){
            final BotApiResponse apiResponse = LineMessagingServiceBuilder
                    .create(channelToken)
                    .build()
                    .replyMessage(
                            new ReplyMessage(
                                    event.getReplyToken(),
                                    Collections.singletonList(
                                            new TextMessage("認証コードが違うよ。"))))
                    .execute()
                    .body();
            return;
        }

        long teamId = Long.parseLong(redisTemplate.opsForValue().get(str));

        Team team = this.teamService.findOne(teamId);

        if(team == null){
            final BotApiResponse apiResponse = LineMessagingServiceBuilder
                    .create(channelToken)
                    .build()
                    .replyMessage(
                            new ReplyMessage(
                                    event.getReplyToken(),
                                    Collections.singletonList(
                                            new TextMessage("認証コードが違うよ。"))))
                    .execute()
                    .body();
            return;
        }else{
            team.setLineGroupId(event.getSource().getSenderId());
            this.teamService.update(team);
            redisTemplate.delete(str);
        }

		final BotApiResponse apiResponse = LineMessagingServiceBuilder
                .create(channelToken)
                .build()
                .replyMessage(
                        new ReplyMessage(
                                event.getReplyToken(),
                                Collections.singletonList(
                                        new TextMessage("認証しました。これからよろしくお願いします。"))))
                .execute()
                .body();
		System.out.println("Sent messages: " + apiResponse);
    }

    @EventMapping
    public void defaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }

    @EventMapping
    public void handleTemplateMessageEvent(PostbackEvent event) throws Exception {
        this.templateMessageHandler.reply(event);
    }

    /**
     * ボットがグループに参加した場合
     * @param event
     */
    @EventMapping
    public void handleJoinEvent(JoinEvent event) throws Exception{

        TextMessage textMessage = new TextMessage("追加ありがとうございます。チームIDを教えてください。");
        ReplyMessage replyMessage = new ReplyMessage(
                event.getReplyToken(),
                textMessage
        );
        Response<BotApiResponse> response =
                LineMessagingServiceBuilder
                        .create(channelToken)
                        .build()
                        .replyMessage(replyMessage)
                        .execute();


        System.out.println(response.code() + " " + response.message());
    }
}
