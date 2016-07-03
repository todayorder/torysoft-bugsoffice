package com.torysoft.bugsoffice.front.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/front")
public class FrontInitController {

	@RequestMapping(value = {" ", "/"})
	public String init() throws Exception {
		
		return "front/front_index";
	}
}
