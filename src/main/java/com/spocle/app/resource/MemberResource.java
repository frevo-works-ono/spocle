package com.spocle.app.resource;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Member;
import com.spocle.domain.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberResource {
	@Autowired
	MemberService memberService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Result create(@RequestBody Member member) {
		Result result = new Result();
		memberService.create(member);

		result.setData(member);
		return result;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Result update(@PathVariable String id, @RequestBody Member member) {
		Result result = new Result();

		if (!id.equals(member.getId())) {
			throw new NotFoundException();
		}

		memberService.update(member);

		result.setData(member);

		return result;
	}

	// @RequestMapping(method = RequestMethod.GET)
	// public Result getCustomer() {
	// List<Member> members = memberService.
	// return service.findAll();
	// }
	//
	// // 顧客一件取得
	// @RequestMapping(method = RequestMethod.GET, value = "{id}")
	// public Member getCustomer(@PathVariable Long id) {
	// return service.findOne(id);
	// }
	//
	// // 顧客一件作成
	// @RequestMapping(method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// public Member postCustomer(@RequestBody Member customer) {
	// return service.create(customer);
	// }
	//
	// // 顧客一件更新
	// @RequestMapping(method = RequestMethod.PUT, value = "{id}")
	// public Member putCustomer(@PathVariable Long id,
	// @RequestBody Member customer) {
	// customer.setId(id);
	// return service.update(customer);
	// }
	//
	// // 顧客一件削除
	// @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	// public void deleteCustomer(@PathVariable Long id) {
	// service.delete(id);
	// }
}
