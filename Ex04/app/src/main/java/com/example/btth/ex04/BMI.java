package com.example.btth.ex04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {
    EditText editTextHeight, editTextWeight, editTextBMI, editTextDiagnosis, editTextName;
    Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextBMI = findViewById(R.id.editTextBMI);
        editTextDiagnosis = findViewById(R.id.editTextDiagnosis);
        editTextName = findViewById(R.id.editTextName);
        buttonCalculate = findViewById(R.id.btnCalculate);
        buttonCalculate.setOnClickListener(v -> {
            String heightText = editTextHeight.getText().toString();
            String weightText = editTextWeight.getText().toString();

            // Kiểm tra người dùng đã nhập chiều cao và cân nặng chưa
            if (!heightText.isEmpty() && !weightText.isEmpty()) {
                try {
                    double height = Double.parseDouble(heightText);
                    double weight = Double.parseDouble(weightText);

                    // Tính chỉ số BMI
                    double bmi = weight / (height * height);

                    // Hiển thị BMI
                    editTextBMI.setText(String.format("%.2f", bmi));

                    // Phân loại và đưa ra kết quả chẩn đoán
                    String diagnosis;
                    if (bmi < 18) {
                        diagnosis = "Người gầy";
                    } else if (bmi >= 18 && bmi <= 24.9) {
                        diagnosis = "Người bình thường";
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        diagnosis = "Người béo phì độ I";
                    } else if (bmi >= 30 && bmi <= 34.9) {
                        diagnosis = "Người béo phì độ II";
                    } else {
                        diagnosis = "Người béo phì độ III";
                    }

                    // Hiển thị chẩn đoán
                    editTextDiagnosis.setText(diagnosis);

                } catch (NumberFormatException e) {
                    // Nếu người dùng nhập không đúng định dạng số
                    editTextBMI.setText("Lỗi định dạng số");
                    editTextDiagnosis.setText("");
                }
            } else {
                // Nếu người dùng chưa nhập chiều cao hoặc cân nặng
                editTextBMI.setText("Vui lòng nhập chiều cao và cân nặng");
                editTextDiagnosis.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}