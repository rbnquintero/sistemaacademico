package com.rbnquintero.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "maestro/home";
	}
}
