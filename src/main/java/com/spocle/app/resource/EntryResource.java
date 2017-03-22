package com.spocle.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.Entry;
import com.spocle.domain.service.EntryService;

@RestController
@RequestMapping("/entries")
public class EntryResource {

  @Autowired
  private EntryService entryService;

  // 顧客一件作成
  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public Result postEntry(@RequestBody Entry customer) {
    Result result = new Result();
    return result;
    // return service.create(customer);
  }
}
