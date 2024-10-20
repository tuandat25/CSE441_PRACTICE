package com.example.btth.ex05;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Schedule extends AppCompatActivity {
    EditText editTextYear;
    TextView textViewResult;
    Button buttonConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schedule);
        editTextYear = findViewById(R.id.editTextYear);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(v -> {
            String yearText = editTextYear.getText().toString();

            // Kiểm tra nếu năm đã được nhập
            if (!yearText.isEmpty()) {
                try {
                    int year = Integer.parseInt(yearText);

                    // Mảng Thiên Can
                    String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};

                    // Mảng Địa Chi
                    String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

                    // Tính chỉ số của can và chi
                    int canIndex = year % 10;
                    int chiIndex = year % 12;

                    // Kết quả năm âm lịch
                    String lunarYear = can[canIndex] + " " + chi[chiIndex];

                    // Hiển thị kết quả
                    textViewResult.setText(lunarYear);

                } catch (NumberFormatException e) {
                    // Nếu nhập sai định dạng số
                    textViewResult.setText("Vui lòng nhập đúng định dạng năm");
                }
            } else {
                // Nếu chưa nhập năm
                textViewResult.setText("Vui lòng nhập năm dương lịch");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}