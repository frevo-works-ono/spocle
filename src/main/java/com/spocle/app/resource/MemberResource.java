package com.spocle.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberResource {
  @Autowired
  MemberService memberService;

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
