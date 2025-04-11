package com.example.radiocolor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    RadioGroup colorRadioGroup;
    RadioButton radioRed, radioBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.rootLayout);
        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        radioRed = findViewById(R.id.radioRed);
        radioBlue = findViewById(R.id.radioBlue);

        colorRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioRed) {
                rootLayout.setBackgroundColor(Color.RED);
            } else if (checkedId == R.id.radioBlue) {
                rootLayout.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
