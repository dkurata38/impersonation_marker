package com.github.we_team2.impersonation_marker.domain;

import lombok.Value;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * 分類スコア
 * 分類名とスコアの一対を表す.
 */
@Value
public class ClassificationScore {
    @NotNull
    public final ClassificationName name;
    @NotNull
    @DecimalMax(value = "1")
    @DecimalMin(value = "0")
    public final Double score;
}
