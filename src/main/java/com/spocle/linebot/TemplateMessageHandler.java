package com.spocle.linebot;

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;

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

    public BotApiResponse reply(PostbackEvent event) throws IOException {
        String data = event.getPostbackContent().getData();

        Response<UserProfileResponse> response = LineMessagingServiceBuilder
                .create(channelToken)
                .build().getProfile(event.getSource().getUserId()).execute();
        String name;
        if (response.isSuccessful()) {
            UserProfileResponse profile = response.body();
            System.out.println(profile.getDisplayName());
            System.out.println(profile.getPictureUrl());
            System.out.println(profile.getStatusMessage());
            name = profile.getDisplayName();
        } else {
            System.out.println(response.code() + " " + response.message());
            name = "ユーザが見つかりません。";
        }

        return lineMessagingService
                .replyMessage(new ReplyMessage(event.getReplyToken(), Collections.singletonList(new TextMessage(name))))
                .execute().body();
    }
}
