package com.tuandat.btth.btth03;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tuandat.btth.btth03.adapter.StudentAdapter;
import com.tuandat.btth.btth03.entities.Student;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Đọc dữ liệu từ file JSON
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.students);
            InputStreamReader reader = new InputStreamReader(inputStream);
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            studentList = new Gson().fromJson(reader, studentListType);

            if (studentList != null) {
                Log.d("MainActivity", "Student list loaded with size: " + studentList.size());
            } else {
                Log.e("MainActivity", "Failed to load student list");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Nếu studentList không phải là null
        if (studentList != null) {
            studentAdapter = new StudentAdapter(studentList);
            recyclerView.setAdapter(studentAdapter);
        } else {
            Log.e("MainActivity", "Student list is null");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}