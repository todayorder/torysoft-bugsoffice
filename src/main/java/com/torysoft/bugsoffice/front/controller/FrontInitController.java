package com.torysoft.bugsoffice.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontInitController {

	@RequestMapping(value = {"", "/"})
	public String init() throws Exception {
		
		return "front/front_index";
	}
}
