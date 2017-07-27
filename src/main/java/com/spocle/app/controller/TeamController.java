package com.spocle.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {
	@RequestMapping(value = "/team", method = RequestMethod.GET)
    public String index() {
        return "team";
    }
	
	@RequestMapping(value = "/team/new", method = RequestMethod.GET)
    public String create() {
        return "teamRegist";
    }
	
	@RequestMapping(value = "/team/new", method = RequestMethod.POST)
	public String regist(){
		return "";
	}
}
