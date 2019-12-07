package com.inventory.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/summary")
	public String summary(Model model) {

		return "summary";
	}
	

	@RequestMapping("/back")
	public String back(Model model) {

		return "summary";
	}

}
