package com.example.btth.ex05;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnConvertSchedule, btnQuadraticEquation;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnConvertSchedule = findViewById(R.id.btnSchedule);
        btnQuadraticEquation = findViewById(R.id.btnQuadraticEquation);
        btnConvertSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Schedule.class);
            startActivity(intent);
        });
        btnQuadraticEquation.setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this, PTBac2.class);
           startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}