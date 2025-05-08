package com.example.surveyapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;



public class MainActivity extends AppCompatActivity {

    String[] questions = {
            "첫인상에서 가장 끌리는 건?",
            "성격 스타일은?",
            "데이트 스타일은?",
            "외모 취향은?",
            "대화 스타일은?",
            "애정 표현은?",
            "연락 스타일은?",
            "취미 맞추기?",
            "이상형 나이차?",
            "제일 중요한 건?"
    };

    String[][] options = {
            {"외모", "목소리", "분위기"},
            {"다정다감", "츤데레", "유쾌상쾌"},
            {"카페 산책", "집콕 영화", "액티비티 폭주"},
            {"댄디", "스트릿", "꾸안꾸"},
            {"차분한 경청", "논리 토론", "귀여운 투정"},
            {"직진", "은근슬쩍", "말보단 행동"},
            {"자주 연락", "필요할 때만", "하루 끝 인사"},
            {"꼭 맞아야 함", "안 맞아도 존중", "상관없음"},
            {"연상", "동갑", "연하"},
            {"신뢰", "설렘", "생활습관"}
    };

    int qIndex = 0;
    HashMap<String, Integer> results = new HashMap<>();
    TextView questionText;
    Button[] optionButtons = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.questionText);
        optionButtons[0] = findViewById(R.id.option1);
        optionButtons[1] = findViewById(R.id.option2);
        optionButtons[2] = findViewById(R.id.option3);
        optionButtons[3] = findViewById(R.id.option4);

        loadQuestion();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            optionButtons[i].setOnClickListener(v -> {
                String selected = options[qIndex][finalI];
                results.put(selected, results.getOrDefault(selected, 0) + 1);
                qIndex++;
                if (qIndex < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("results", results);
                    startActivity(intent);
                    finish();
                }
            });
        }

        // 4번째 버튼 숨기기 (질문마다 3개만 있음)
        optionButtons[3].setVisibility(View.GONE);
    }

    private void loadQuestion() {
        questionText.setText(questions[qIndex]);
        for (int i = 0; i < 3; i++) {
            optionButtons[i].setText(options[qIndex][i]);
        }
    }
}
