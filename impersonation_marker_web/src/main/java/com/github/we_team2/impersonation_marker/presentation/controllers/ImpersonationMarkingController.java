package com.github.we_team2.impersonation_marker.presentation.controllers;

import com.github.we_team2.impersonation_marker.application.service.ImpersonationMarkingService;
import com.github.we_team2.impersonation_marker.presentation.form.ImpersonationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ImpersonationMarkingController {
    private final ImpersonationMarkingService service;

    public ImpersonationMarkingController(ImpersonationMarkingService service) {
        this.service = service;
    }

    @PostMapping("mark")
    public String mark(@Valid ImpersonationForm impersonationForm, Model model) {
        service.mark(impersonationForm.getUploadedFile());

        model.addAttribute("filename", impersonationForm.getUploadedFile().getOriginalFilename());
        return "score";
    }
}
