package com.tuandat.btth.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private TextView textViewName, textViewGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewName = findViewById(R.id.textViewName);
        textViewGPA = findViewById(R.id.textViewGPA);
        Button btnGoToSecondActivity = findViewById(R.id.btnGoToSecondActivity);
        btnGoToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang màn hình thứ 2
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Nhận kết quả trả về từ SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            // Lấy dữ liệu từ Intent
            String name = data.getStringExtra("name");
            String gpa = data.getStringExtra("gpa");

            // Hiển thị dữ liệu lên TextView
            textViewName.setText("Họ và tên: " + name);
            textViewGPA.setText("Điểm GPA: " + gpa);
        }
    }
}