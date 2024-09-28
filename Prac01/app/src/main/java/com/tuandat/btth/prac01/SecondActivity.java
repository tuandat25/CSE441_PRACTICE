package com.tuandat.btth.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextName, editTextGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        // Hiển thị nút "Up" trên Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        editTextName = findViewById(R.id.textInputName);
        editTextGPA = findViewById(R.id.textInputGPA);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText
                String name = editTextName.getText().toString();
                String gpa = editTextGPA.getText().toString();

                // Tạo Intent để chứa dữ liệu trả về MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa", gpa);

                // Đặt kết quả và kết thúc activity
                setResult(RESULT_OK, resultIntent);
                finish();  // Quay lại MainActivity
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Xử lý sự kiện khi nhấn nút "Up"
    @Override
    public boolean onSupportNavigateUp() {
        // Quay lại MainActivity
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();  // Kết thúc SecondActivity để ngăn nó tồn tại trong back stack
        return true;
    }
}