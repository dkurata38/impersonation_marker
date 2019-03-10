package com.github.we_team2.impersonation_marker.application.service;

import com.github.we_team2.impersonation_marker.application.client.ClassificationExecutor;
import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImpersonationMarkingServiceImpl implements ImpersonationMarkingService {

    private ClassificationExecutor executor;

    /**
     * 得点を計算するサービス.
     * @param audio ユーザーから受け取った音声データ.
     * @return
     */
    @Override
    public ClassificationResult mark(MultipartFile audio) {

        // Fileを保存するよ

        // Pythonファイルを実行するよ

        // 正解データにバインドするよ


        return null;
    }
}
