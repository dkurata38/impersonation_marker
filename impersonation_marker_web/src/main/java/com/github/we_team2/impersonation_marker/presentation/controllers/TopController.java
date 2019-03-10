package com.github.we_team2.impersonation_marker.presentation.controllers;

import com.github.we_team2.impersonation_marker.presentation.form.ImpersonationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
	@GetMapping("/")
	public String index(ImpersonationForm impersonationForm, Model model) {

		return "index";
	}
}
