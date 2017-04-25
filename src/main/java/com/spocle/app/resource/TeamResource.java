package com.spocle.app.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spocle.domain.model.entity.Team;
import com.spocle.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Member;
import com.spocle.domain.service.MemberService;

@RestController
@RequestMapping("/teams")
public class TeamResource {
  @Autowired
  MemberService memberService;

  @Autowired
  TeamService teamService;

  @RequestMapping(method = RequestMethod.GET, value = "{id}/members")
  public Result getMembers(@PathVariable Long id) {
    List<Member> members = memberService.findByTeamId(id);
    Result result = new Result();
    result.setData(members);
    return result;
  }


  @RequestMapping(method = RequestMethod.POST)
  public Result create(Team team){
    Result result = new Result();
    teamService.create(team);

    Map<String,String> data = new HashMap<>();
    data.put("code","1234");
    result.setData(data);

    return result;

  }

}
