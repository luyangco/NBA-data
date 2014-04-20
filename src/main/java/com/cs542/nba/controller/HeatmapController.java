package com.cs542.nba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("heatmap")
public class HeatmapController {

	@RequestMapping(method = RequestMethod.GET)
	public String handleIndex() {
		return "heatmap";
	}

}
