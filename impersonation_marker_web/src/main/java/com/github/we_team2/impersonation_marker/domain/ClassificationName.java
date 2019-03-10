package com.github.we_team2.impersonation_marker.domain;

public enum ClassificationName {
    POSITIVE("positive"), NEGATIVE("negative");

    public final String value;

    ClassificationName(String value) {
        this.value = value;
    }
}
