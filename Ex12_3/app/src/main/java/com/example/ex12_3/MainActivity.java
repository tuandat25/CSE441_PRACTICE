package com.example.ex12_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String arr1[]= {"Hàng Điện tử","Hàng Hóa Chất",
            "Hàng Gia dụng","Hàng xây dựng"};
    TextView txt1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        Spinner spin1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_spinner_item,arr1);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin1.setAdapter(adapter1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                txt1.setText(arr1[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}





