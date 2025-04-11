package com.example.calculator3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    TextView tvResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = etNumber1.getText().toString();
                String input2 = etNumber2.getText().toString();

                if (input1.isEmpty() || input2.isEmpty()) {
                    tvResult.setText("숫자를 입력하세요.");
                    return;
                }

                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);
                double result = 0;

                if (v.getId() == R.id.btnAdd) {
                    result = num1 + num2;
                } else if (v.getId() == R.id.btnSub) {
                    result = num1 - num2;
                } else if (v.getId() == R.id.btnMul) {
                    result = num1 * num2;
                } else if (v.getId() == R.id.btnDiv) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        tvResult.setText("0으로 나눌 수 없습니다.");
                        return;
                    }
                }


                tvResult.setText("결과: " + result);
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }
}
