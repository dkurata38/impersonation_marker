package com.github.we_team2.impersonation_marker.application.service;

import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * ものまね音声の点数を計算するモデルを戻すサービス.
 */
public interface ImpersonationMarkingService {
    /**
     * 得点を計算するサービス.
     * @param audio ユーザーから受け取った音声データ.
     * @return
     */
    Optional<ClassificationResult> mark(MultipartFile audio);
}
