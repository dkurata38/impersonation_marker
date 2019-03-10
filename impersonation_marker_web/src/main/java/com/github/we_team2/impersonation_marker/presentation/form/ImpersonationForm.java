package com.github.we_team2.impersonation_marker.presentation.form;

import com.github.we_team2.impersonation_marker.presentation.validator.FileRequired;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ImpersonationForm implements Serializable {

    @FileRequired
    private MultipartFile uploadedFile;

}
