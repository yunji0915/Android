package com.example.mission44;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private String currentInput = "";
    private String lastOperator = "";
    private double firstOperand = 0;
    private double secondOperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);

        // 숫자 버튼 클릭 리스너
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                currentInput += button.getText().toString();
                resultText.setText(currentInput);
            }
        };

        // 연산자 버튼 클릭 리스너
        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                lastOperator = button.getText().toString();
                firstOperand = Double.parseDouble(currentInput);
                currentInput = "";
            }
        };

        // "=" 버튼 클릭 리스너
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = Double.parseDouble(currentInput);

                // 백그라운드에서 계산
                new CalculateTask().execute();
            }
        });

        // 버튼 설정
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        // 숫자 버튼 리스너 설정
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        button0.setOnClickListener(numberListener);

        // 연산자 버튼 리스너 설정
        buttonAdd.setOnClickListener(operatorListener);
    }

    // AsyncTask로 계산 처리
    private class CalculateTask extends AsyncTask<Void, Void, Double> {

        @Override
        protected Double doInBackground(Void... params) {
            double result = 0;
            switch (lastOperator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                // 다른 연산자들 처리 가능
            }
            return result;
        }

        @Override
        protected void onPostExecute(Double result) {
            resultText.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        }
    }
}
