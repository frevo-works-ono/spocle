package com.spocle.app.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.action.URIAction;
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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @Autowired
    private TeamService teamService;

    @Value("${line.bot.channel-token}")
    private String channelToken;
    
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Result find(@PathVariable String id){
    	Result result = new Result();
    	
    	Event event = eventService.findOne(id);
    	
    	if(event == null){
    		throw new NotFoundException();
    	}
    	
    	result.setData(event);
    	
    	return result;
    }

    /**
     * @returnΩ
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestBody Event event) {
        Result result = new Result();
        
        // TODO サブドメインから取得
        
        String teamId = "a990896d-68f5-4852-8757-c55ea1f8a61f";
        
        Team team = teamService.findOne(teamId);
        
        if(team == null){
        	throw new NotFoundException();
        }
        
        event.setTeam(new Team(teamId));

        eventService.create(event);
        
        result.setData(event);
        
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}/push")
    public Result push(@PathVariable String id) throws IOException {

        Result result = new Result();

        Event event = eventService.findOne(id);
        
        if(event == null){
        	throw new NotFoundException();
        }

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Action> actions = new ArrayList<>();
        
        actions.add(new URIAction("詳細を見る","http://www.akb48.co.jp/"));
   
        Template template = new ButtonsTemplate(null, null, event.getEventInfo(), actions);

        PushMessage pushMessage = new PushMessage(
        		event.getTeam().getLineGroupId(),
                new TemplateMessage("イベントのお知らせ", template)
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
