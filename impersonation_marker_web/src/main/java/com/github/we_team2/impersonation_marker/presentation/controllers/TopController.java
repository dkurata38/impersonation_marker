package com.github.we_team2.impersonation_marker.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
	@GetMapping("/")
	public String index() {


		return "index";
	}
}
