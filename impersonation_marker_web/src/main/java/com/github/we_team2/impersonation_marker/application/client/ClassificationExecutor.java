package com.github.we_team2.impersonation_marker.application.client;

import com.github.we_team2.impersonation_marker.domain.ClassificationResult;

import java.util.Optional;

public interface ClassificationExecutor {
    Optional<ClassificationResult> classify(String testFilePath);
}
