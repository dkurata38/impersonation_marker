package com.github.we_team2.impersonation_marker.application.service;

import com.github.we_team2.impersonation_marker.application.client.ClassificationExecutor;
import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class ImpersonationMarkingServiceImpl implements ImpersonationMarkingService {

    private ClassificationExecutor executor;

    public ImpersonationMarkingServiceImpl(ClassificationExecutor executor) {
        this.executor = executor;
    }

    /**
     * 得点を計算するサービス.
     * @param audio ユーザーから受け取った音声データ.
     * @return
     */
    @Override
    public Optional<ClassificationResult> mark(MultipartFile audio) {

        // ファイル種類から決まる値をセットする
        ResourceBundle bundle = ResourceBundle.getBundle("application");
        String directoryPath = bundle.getString("audio.directory.path");
        File uploadDir = new File(directoryPath);

        try {
            // アップロードファイルを置く
            String filePath = uploadDir.getPath() + File.separator + Instant.now().toString() + audio.getOriginalFilename();
            File uploadFile =
                    new File(filePath);
            uploadFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(uploadFile);
            fos.write(audio.getBytes());
            fos.close();

            Optional<ClassificationResult> classificationResult = executor.classify(filePath);
            return classificationResult;

        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
