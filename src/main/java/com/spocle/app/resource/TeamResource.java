package com.spocle.app.resource;

import java.util.List;

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

  @RequestMapping(method = RequestMethod.GET, value = "{id}/members")
  public Result getMembers(@PathVariable Long id) {
    List<Member> members = memberService.findByTeamId(id);
    Result result = new Result();
    result.setData(members);
    return result;
  }

}
