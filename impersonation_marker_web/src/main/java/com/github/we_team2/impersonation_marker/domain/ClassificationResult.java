package com.github.we_team2.impersonation_marker.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 分類した結果を表す.
 *
 * 複数のクラスのスコアから, ものまねの点数を計算する.
 */
@RequiredArgsConstructor
public class ClassificationResult {
    private final List<ClassificationScore> classificationScores;

    public Double point(double positive_prob) {
        return positive_prob * 100;
    }
}
