package com.example.temperature;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText temperatureInput;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 연결
        temperatureInput = findViewById(R.id.temperatureInput);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        // 버튼 클릭 시 변환
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "온도를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double temperature = Double.parseDouble(input);
                    String result = convertTemperature(temperature);
                    resultText.setText(result);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "유효한 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 섭씨 -> 화씨 변환 또는 화씨 -> 섭씨 변환
    private String convertTemperature(double temperature) {
        double convertedTemp;
        if (temperature < -459.67) {
            return "불가능한 온도입니다.";
        }

        if (temperature > -273.15) {
            // 섭씨 -> 화씨 변환
            convertedTemp = (temperature * 9/5) + 32;
            return String.format("%.2f 섭씨는 %.2f 화씨입니다.", temperature, convertedTemp);
        } else {
            // 화씨 -> 섭씨 변환
            convertedTemp = (temperature - 32) * 5/9;
            return String.format("%.2f 화씨는 %.2f 섭씨입니다.", temperature, convertedTemp);
        }
    }
}
