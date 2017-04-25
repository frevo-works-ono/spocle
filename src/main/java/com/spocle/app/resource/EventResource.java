package com.spocle.app.resource;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.Template;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.LineBotProperties;
import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Event;
import com.spocle.domain.model.entity.Team;
import com.spocle.domain.service.EventService;
import com.spocle.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @Autowired
    private TeamService teamService;

    @Value("${line.bot.channel-token}")
    private String channelToken;

    /**
     * @returnΩ
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result create() {
        Result result = new Result();

        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}/push")
    public Result push(@PathVariable long id) throws IOException {

        Result result = new Result();

        Event event = eventService.findOne(id);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Team team = teamService.findOne()

        List<Action> actions = new ArrayList<>();

        actions.add(new PostbackAction("イベントが", "hoge=1"));

        Template template = new ButtonsTemplate("https://lh3.googleusercontent.com/proxy/BUtxlzq4ndpiGfWqbXb-s6qoI5amio4J5iHgokd6s1qHGEX9U89rhirRqlEIYsLzVDMonIorwbfvMTaU4_NKpRApjHpidfzZhCcyivqO8Uvd3234w43Xqg=w359-h409-nc", "label", "text", actions);

        PushMessage pushMessage = new PushMessage(
                "U1ed0f26a5788029d88ce72d08ff39172",
                new TemplateMessage("textaaaaa", template)
        );

        LineBotProperties lineProperties = new LineBotProperties();

        Response<BotApiResponse> response =
                LineMessagingServiceBuilder
                        .create(channelToken)
                        .build()
                        .pushMessage(pushMessage)
                        .execute();

        System.out.println(response.code() + " " + response.message());

        return result;
    }
}
