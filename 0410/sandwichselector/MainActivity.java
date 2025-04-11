package com.example.twobuttons;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    Button basicButton;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.rootLayout);
        basicButton = findViewById(R.id.basicButton);
        materialButton = findViewById(R.id.materialButton);

        basicButton.setOnClickListener(v -> rootLayout.setBackgroundColor(Color.YELLOW));
        materialButton.setOnClickListener(v -> rootLayout.setBackgroundColor(Color.MAGENTA));
    }
}
