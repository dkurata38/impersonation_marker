package com.github.we_team2.impersonation_marker.presentation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * ファイルがアップロードされたかを検証するためのアノテーション.
 * messageはinvalid.file_requiredというキーで設定すること.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileRequiredValidator.class)
public @interface FileRequired {
    String message() default "{invalid.file_required}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FileRequired[] value();
    }
}
