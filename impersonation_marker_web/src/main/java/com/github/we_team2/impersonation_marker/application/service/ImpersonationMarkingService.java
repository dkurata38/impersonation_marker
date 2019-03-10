package com.github.we_team2.impersonation_marker.application.service;

import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import org.springframework.stereotype.Service;

/**
 * ものまね音声の点数を計算するモデルを戻すサービス.
 */
@Service
public interface ImpersonationMarkingService {
    /**
     * 得点を計算するサービス.
     * @return
     */
    ClassificationResult mark();
}
