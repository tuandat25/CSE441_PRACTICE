package com.tuandat.btth.ex01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_A, edt_B, edt_Result;
    Button btn_Sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_A = findViewById(R.id.edt_A);
        edt_B = findViewById(R.id.edt_B);
        edt_Result = findViewById(R.id.edt_Result);
        btn_Sum = findViewById(R.id.btn_Sum);
        btn_Sum.setOnClickListener(v -> {
            caculateSum();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void caculateSum() {
        String str_Number_A = edt_A.getText().toString();
        String str_Number_B = edt_B.getText().toString();

        if(str_Number_A.isEmpty() || str_Number_B.isEmpty()) {
            edt_Result.setText("Please enter two numbers");
            return;
        }

        try {
            int number_A = Integer.parseInt(str_Number_A);
            int number_B = Integer.parseInt(str_Number_B);

            int result = number_A + number_B;
            edt_Result.setText(String.valueOf(result));
        }catch (NumberFormatException e){
            edt_Result.setText("Please enter number");
        }

    }
}