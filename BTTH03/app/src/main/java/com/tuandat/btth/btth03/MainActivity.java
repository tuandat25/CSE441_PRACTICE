package com.tuandat.btth.btth03;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        Drawable overflowIcon = toolbar.getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP); // Đổi màu icon thành trắng
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sort) {
            Toast.makeText(this, "Sắp xếp", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.sortById) {
            Toast.makeText(this, "Sắp xếp theo má SV", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.sortByGpa) {
            Toast.makeText(this, "Sắp xếp theo điểm", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}