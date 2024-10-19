package com.example.btth.ex03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtResult;
    Button btncong, btntru, btnnhan, btnchia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtResult = findViewById(R.id.edtResult);
        btncong = findViewById(R.id.btnSum);
        btntru = findViewById(R.id.btnHieu);
        btnnhan = findViewById(R.id.btnNhan);
        btnchia = findViewById(R.id.btnThuong);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtResult.setText("" +(a+b));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtResult.setText("" +(a-b));
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtResult.setText("" +(a*b));
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                if (b == 0)
                {
                    edtResult.setText("B phai khac 0");
                }
                else
                {
                    edtResult.setText(a/b + "");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}