package com.example.btth.ex04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConvertForm extends AppCompatActivity {
    EditText editTextFahrenheit, editTextCelsius;
    Button buttonConvertCelsius, buttonConvertFahrenheit, buttonClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_convert_form);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonConvertCelsius = findViewById(R.id.buttonConvertCelsius);
        buttonConvertFahrenheit = findViewById(R.id.buttonConvertFahrenheit);
        buttonClear = findViewById(R.id.buttonClear);

        buttonConvertCelsius.setOnClickListener(v -> {
            String fahrenheitText = editTextFahrenheit.getText().toString();
            if (!fahrenheitText.isEmpty()) {
                double fahrenheit = Double.parseDouble(fahrenheitText);
                double celsius = (fahrenheit - 32) / 1.8;
                editTextCelsius.setText(String.valueOf(celsius));
            } else {
                editTextCelsius.setText(""); // Hoặc hiển thị thông báo lỗi
            }
        });

        buttonConvertFahrenheit.setOnClickListener(v -> {
            String celsiusText = editTextCelsius.getText().toString();
            if (!celsiusText.isEmpty()) {
                double celsius = Double.parseDouble(celsiusText);
                double fahrenheit = celsius * 1.8 + 32;
                editTextFahrenheit.setText(String.valueOf(fahrenheit));
            } else {
                editTextFahrenheit.setText(""); // Hoặc hiển thị thông báo lỗi
            }
            //

        });

        buttonClear.setOnClickListener(v -> {
            editTextCelsius.setText("");
            editTextFahrenheit.setText("");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}