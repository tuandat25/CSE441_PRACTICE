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
            double celsius = Double.parseDouble(editTextCelsius.getText().toString());
            double fahrenheit = celsius * 1.8 + 32;
            editTextFahrenheit.setText(String.valueOf(fahrenheit));
        });

        buttonConvertFahrenheit.setOnClickListener(v -> {
            double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
            double celsius = (fahrenheit - 32) / 1.8;
            editTextCelsius.setText(String.valueOf(celsius));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}