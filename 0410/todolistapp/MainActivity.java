package com.example.todolistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private Button addTaskButton;
    private LinearLayout taskListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 연결
        taskInput = findViewById(R.id.taskInput);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListContainer = findViewById(R.id.taskListContainer);

        // 추가 버튼 클릭 시 동작
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString().trim();

                if (task.isEmpty()) {
                    Toast.makeText(MainActivity.this, "할 일을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 새로운 체크박스 추가
                CheckBox taskCheckBox = new CheckBox(MainActivity.this);
                taskCheckBox.setText(task);
                taskCheckBox.setTextSize(18);
                taskCheckBox.setPadding(16, 16, 16, 16);

                // 추가된 할일 항목을 레이아웃에 추가
                taskListContainer.addView(taskCheckBox);

                // 할일 입력 칸 초기화
                taskInput.setText("");
            }
        });
    }
}
