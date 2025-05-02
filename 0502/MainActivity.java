package com.example.gallery; // 패키지명 맞게 바꿔줘

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView titleText;
    ImageView imageView;
    Button prevButton, nextButton;

    int index = 0;

    int[] imageIds = {
            R.drawable.sample1,
            R.drawable.sample2,
            R.drawable.sample3,
            R.drawable.sample4,
            R.drawable.sample5
    };

    String[] titles = {
            "시집 1: 첫눈처럼 너에게 가겠다",
            "시집 2: 너는 눈부시지만 나는 괜찮아",
            "시집 3: 아무튼, 하루",
            "시집 4: 우리가 사랑한 정오",
            "시집 5: 너의 계절"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);
        imageView = findViewById(R.id.imageView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        updateContent();

        prevButton.setOnClickListener(v -> {
            index = (index - 1 + imageIds.length) % imageIds.length;
            updateContent();
        });

        nextButton.setOnClickListener(v -> {
            index = (index + 1) % imageIds.length;
            updateContent();
        });
    }

    private void updateContent() {
        imageView.setImageResource(imageIds[index]);
        titleText.setText(titles[index]);
    }
}
