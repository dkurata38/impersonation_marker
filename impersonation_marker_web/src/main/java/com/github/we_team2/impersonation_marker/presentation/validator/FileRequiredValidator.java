package com.github.we_team2.impersonation_marker.presentation.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileRequiredValidator implements ConstraintValidator<FileRequired, MultipartFile> {
    @Override
    public void initialize(FileRequired constraint) {}

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        return multipartFile != null
                && !multipartFile.getOriginalFilename().isEmpty();
    }
}