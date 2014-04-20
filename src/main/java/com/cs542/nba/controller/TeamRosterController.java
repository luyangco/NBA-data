package com.cs542.nba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("team")
public class TeamRosterController {

	@RequestMapping(method = RequestMethod.GET)
	public String handleIndex() {
		return "team";
	}
}
