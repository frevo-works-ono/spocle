package com.spocle.linebot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by h.ono on 2017/04/08.
 */
@Service
public class TemplateMessageHandler {
    private final LineMessagingService lineMessagingService;

    @Value("${line.bot.channel-token}")
    private String channelToken;

    public TemplateMessageHandler(LineMessagingService lineMessagingService) {
        super();
        this.lineMessagingService = lineMessagingService;
    }

//    public BotApiResponse reply(PostbackEvent event) throws IOException {
//        String data = event.getPostbackContent().getData();
//        
//        Map<String,String> postbackData = new ObjectMapper().readValue(data, Map.class);
//        String messageType = postbackData.get("messageType");
//        String replyMessage = "";
//        if(PushMessageType.MEMBER_REGIST.getCode().equals(messageType)){
//        	MemberRegistDto dto = new ObjectMapper().readValue(data, MemberRegistDto.class);
//        	replyMessage = memberRegistService.exec(event.getSource().getUserId(),dto);
//        }else if(PushMessageType.EVENT_ENTRY.getCode().equals(messageType)){
//        	EventEntryDto dto = new ObjectMapper().readValue(data, EventEntryDto.class);
//        	replyMessage = eventEntryService.exec(event.getSource().getUserId(), dto);
//        }
//
//        return lineMessagingService
//                .replyMessage(new ReplyMessage(event.getReplyToken(), Collections.singletonList(new TextMessage(replyMessage))))
//                .execute().body();
//    }
}
