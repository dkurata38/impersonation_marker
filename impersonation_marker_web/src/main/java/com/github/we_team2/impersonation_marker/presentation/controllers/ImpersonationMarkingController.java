package com.github.we_team2.impersonation_marker.presentation.controllers;

import com.github.we_team2.impersonation_marker.application.service.ImpersonationMarkingService;
import com.github.we_team2.impersonation_marker.presentation.form.ImpersonationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ImpersonationMarkingController {
    private final ImpersonationMarkingService service;


    public ImpersonationMarkingController(ImpersonationMarkingService service) {
        this.service = service;
    }

    @PostMapping("mark")
    public String mark(ImpersonationForm impersonationForm, Model model) {
        return null;
    }
}
