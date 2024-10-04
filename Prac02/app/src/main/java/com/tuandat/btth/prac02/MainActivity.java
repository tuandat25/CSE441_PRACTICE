package com.tuandat.btth.prac02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;

    private TextView textViewResult;
    private TextView textViewMessage;
    private EditText editTextId;
    private EditText editTextFullname;
    private EditText editTextBirthdate;
    private EditText editTextSalary;
    private Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        textViewResult = findViewById(R.id.textViewResult);
        editTextId = findViewById(R.id.editTextId);
        editTextFullname = findViewById(R.id.editTextFullname);
        editTextBirthdate = findViewById(R.id.editTextBirthdate);
        editTextSalary = findViewById(R.id.editTextSalary);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonAdd = findViewById(R.id.buttonAdd);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Quan sát sự thay đổi của dữ liệu
        myViewModel.getItems().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> items) {
                // Cập nhật TextView khi danh sách thay đổi
                if (items == null || items.isEmpty()) {
                    textViewResult.setText("No Result!");
                }
                else{
                    StringBuilder displayText = new StringBuilder();
                    for (String item : items) {
                        displayText.append(item).append("\n");
                    }
                    textViewResult.setText(displayText.toString());
                }

            }
        });

        // Xử lý sự kiện thêm mới
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String name = editTextFullname.getText().toString();
                String birthdate = editTextBirthdate.getText().toString();
                String salary = editTextSalary.getText().toString();
                if (!id.isEmpty() && !name.isEmpty() && !birthdate.isEmpty() && !salary.isEmpty()) {
                    String newItem = id + "-" + name + "-" + birthdate + "-" + salary; // Tạo item mới dạng "S100 - Lê Văn Lương"
                    myViewModel.addItem(newItem); // Thêm vào ViewModel
                    editTextId.setText(""); // Xóa input sau khi nhập
                    editTextFullname.setText("");
                    editTextBirthdate.setText("");
                    editTextSalary.setText("");
                    textViewMessage.setText("Đã ấn nút thêm mới");
                    if (myViewModel.getItems().getValue().size() >= 3) {
                        textViewMessage.setText("Đã thêm vài nhân viên");
                    }
                }
            }
        });

        //Xu li kiem tra nguoi dung nhap
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextId.getText().toString().isEmpty()
                        && !editTextFullname.getText().toString().isEmpty()
                        && !editTextBirthdate.getText().toString().isEmpty()
                        && !editTextSalary.getText().toString().isEmpty()) {
                    textViewMessage.setText("Đã nhập nhưng chưa ấn nút");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editTextId.addTextChangedListener(textWatcher);
        editTextFullname.addTextChangedListener(textWatcher);
        editTextBirthdate.addTextChangedListener(textWatcher);
        editTextSalary.addTextChangedListener(textWatcher);

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}