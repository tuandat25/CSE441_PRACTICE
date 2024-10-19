package com.example.btth.btth04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btth.btth04.entities.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextClass, editTextGPA;
    Button btnAdd, btnUpdate, btnDelete;
     RecyclerView recyclerView;
     StudentAdapter studentAdapter;
     List<Student> studentList;
    FirebaseDatabaseHelper firebaseDatahelper;
    DatabaseReference databaseReference;
    String idStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //bât khả năng lưu trữ cục bộ (trên thiết bị) của firebasedatabase khi không có kết nối mạng
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        setContentView(R.layout.activity_main);
        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Khởi tạo EditText, Button
        editTextName = findViewById(R.id.editTextName);
        editTextClass = findViewById(R.id.editTextClass);
        editTextGPA = findViewById(R.id.editTextGPA);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonEdit);
        btnDelete = findViewById(R.id.buttonXoa);

        // Khởi tạo danh sách sinh viên
        studentList = new ArrayList<>();
        studentList.add(new Student("1", "Nguyen Van A", "12A1", 8.5));
        studentList.add(new Student("2", "Tran Thi B", "12A2", 7.8));
        studentList.add(new Student("3", "Le Van C", "12A3", 9.0));

        // Gán Adapter cho RecyclerView
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(studentAdapter);

        firebaseDatahelper = new FirebaseDatabaseHelper();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        // Check connection
        checkFirebaseConnection();
        readFromDatabase();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void checkFirebaseConnection() {
        databaseReference.child("testConnection").setValue("Hello, Firebase!")
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Connected to Firebase Realtime Database", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to connect to Firebase", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void readFromDatabase() {
        databaseReference.child("testConnection").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                String value = task.getResult().getValue(String.class);
                Toast.makeText(MainActivity.this, "Read value: " + value, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Failed to read value", Toast.LENGTH_SHORT).show();
            }
        });
    }
}