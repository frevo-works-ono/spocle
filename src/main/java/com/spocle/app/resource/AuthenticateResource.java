package com.spocle.app.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Member;
import com.spocle.domain.service.MemberService;
import com.spocle.util.CookieUtil;
import com.spocle.util.TokenGenerator;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateResource {

	@Autowired
	MemberService memberService;

	@Autowired
	StringRedisTemplate redisTemplate;

	@RequestMapping(method = RequestMethod.POST)
	public Result auth(@RequestBody String memberId, HttpServletResponse response) {
		Result result = new Result();

		Member member = memberService.findOne(memberId);

		if (member == null) {
			throw new NotFoundException("メンバーが登録されていません。");
		}

		String token = TokenGenerator.generate();

		redisTemplate.opsForValue().set(token, member.getId());

		response.addCookie(CookieUtil.use().get(token, member.getId()));

		return result;
	}
}
