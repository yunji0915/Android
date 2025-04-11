package com.example.surveyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup versionGroup;
    private Button displayButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 연결
        versionGroup = findViewById(R.id.versionGroup);
        displayButton = findViewById(R.id.displayButton);
        imageView = findViewById(R.id.imageView);

        // DISPLAY IMAGE 버튼 클릭 시 동작
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = versionGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "버전을 선택하세요", Toast.LENGTH_SHORT).show();
                } else {
                    showImageForVersion(selectedId);
                }
            }
        });
    }

    // 선택한 버전에 맞는 이미지를 보여주는 메서드
    private void showImageForVersion(int selectedId) {
        ImageView imageView = findViewById(R.id.imageView);

        // 이미지 리소스를 선택
        switch (selectedId) {
            case R.id.version3_0:
                imageView.setImageResource(R.drawable.android_3_0); // 3.0 버전 이미지
                break;
            case R.id.version2_0:
                imageView.setImageResource(R.drawable.android_2_0); // 2.0 버전 이미지
                break;
            case R.id.version5_0:
                imageView.setImageResource(R.drawable.android_5_0); // 5.0 버전 이미지
                break;
            default:
                imageView.setImageResource(0); // 기본 이미지 초기화
                break;
        }
    }
}
