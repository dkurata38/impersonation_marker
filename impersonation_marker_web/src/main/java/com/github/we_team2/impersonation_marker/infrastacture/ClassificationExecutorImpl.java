package com.github.we_team2.impersonation_marker.infrastacture;

import com.github.we_team2.impersonation_marker.application.client.ClassificationExecutor;
import com.github.we_team2.impersonation_marker.domain.ClassificationResult;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

@Component
public class ClassificationExecutorImpl implements ClassificationExecutor {
    final String commandFilePath = "";
    @Override
    public Optional<ClassificationResult> classify(String testFilePath) {
        String text;
        try {
            Process process = new ProcessBuilder("py", commandFilePath, testFilePath).start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = bufferedReader.read()) != -1) {
                builder.append((char)c);
            }
            text = builder.toString();
            int exitCode = process.waitFor();
            JSONObject jsonObject = new org.json.JSONObject(text);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
