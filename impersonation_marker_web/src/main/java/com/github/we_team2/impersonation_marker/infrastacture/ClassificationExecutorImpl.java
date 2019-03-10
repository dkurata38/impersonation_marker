package com.github.we_team2.impersonation_marker.infrastacture;

import com.github.we_team2.impersonation_marker.application.client.ClassificationExecutor;
import com.github.we_team2.impersonation_marker.domain.ClassificationName;
import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import com.github.we_team2.impersonation_marker.domain.ClassificationScore;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class ClassificationExecutorImpl implements ClassificationExecutor {
    ResourceBundle bundle = ResourceBundle.getBundle("application");
    final String commandFilePath = bundle.getString("classification.script.path");
    @Override
    public Optional<ClassificationResult> classify(String testFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", commandFilePath, testFilePath);
            Process process = processBuilder.start();
            InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char)c);
            }

            process.waitFor();
//            System.out.println(builder.toString());
            JSONObject object = new JSONObject(builder.toString());
            List<ClassificationScore> classificationScoreList = new ArrayList<>();
            classificationScoreList.add(
                    new ClassificationScore(ClassificationName.POSITIVE, object.getDouble(ClassificationName.POSITIVE.value)));
            classificationScoreList.add(
                    new ClassificationScore(ClassificationName.NEGATIVE, object.getDouble(ClassificationName.NEGATIVE.value)));

            return Optional.of(new ClassificationResult(classificationScoreList));
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
