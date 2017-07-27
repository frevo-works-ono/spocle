package com.spocle.app.resource;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.spocle.domain.model.dto.Result;
import com.spocle.domain.model.entity.User;
import com.spocle.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Result find(@PathVariable String id){
		Result result = new Result();
		
		User user = userService.findOne(id);
		
		if(user == null){
			throw new NotFoundException();
		}
		
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Result create(@RequestBody User user){
		Result result = new Result();
		
		User entity = userService.create(user);
		
		result.setData(entity);
		
		return result;
	}
}
