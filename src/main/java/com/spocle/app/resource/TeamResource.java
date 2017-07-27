package com.spocle.app.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Event;
import com.spocle.domain.model.entity.Member;
import com.spocle.domain.model.entity.Team;
import com.spocle.domain.service.EventService;
import com.spocle.domain.service.MemberService;
import com.spocle.domain.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamResource {

	@Value("${line.bot.channel-token}")
	private String channelToken;

	@Autowired
	MemberService memberService;

	@Autowired
	EventService eventService;

	@Autowired
	TeamService teamService;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "{id}/members")
	public Result getMembers(@PathVariable String id) {
		List<Member> members = memberService.findByTeamId(id);
		Result result = new Result();
		result.setData(members);
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/events")
	public Result getEvents(@PathVariable String id) {

		Result result = new Result();

		List<Event> events = eventService.findByTeamId(id);

		result.setData(events);

		return result;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Result create(@RequestBody Team team) {
		Result result = new Result();
		teamService.create(team);

		redisTemplate.opsForValue().set("1234", team.getId(), 10, TimeUnit.MINUTES);

		Map<String, String> data = new HashMap<>();
		data.put("code", "1234");
		result.setData(data);

		return result;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Result update(@PathVariable String id, @RequestBody Team team) {
		Result result = new Result();

		if (!id.equals(team.getId())) {
			throw new NotFoundException();
		}

		teamService.update(team);

		result.setData(team);

		return result;
	}

}
