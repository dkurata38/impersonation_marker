package com.github.we_team2.impersonation_marker.presentation.form;

import com.github.we_team2.impersonation_marker.presentation.validator.FileRequired;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImpersonationForm {
    @FileRequired
    private MultipartFile uploadedFile;

}
