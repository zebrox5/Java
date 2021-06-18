package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/home")
	public String view2()
	{
		return "home";
	}
	
	@RequestMapping("/contact")
	public String view3()
	{
		return "contact";
	}

}
