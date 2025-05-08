package com.example.surveyapp2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);

        HashMap<String, Integer> results =
                (HashMap<String, Integer>) getIntent().getSerializableExtra("results");

        StringBuilder resultText = new StringBuilder();

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            resultText.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("회 선택됨\n");
        }

        resultTextView.setText(resultText.toString());
    }
}
