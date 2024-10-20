package com.example.btth.ex05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PTBac2 extends AppCompatActivity {
    EditText edtA, edtB, edtC;
    TextView tvKetQua;
    Button btnCalc, btnCancel, btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

// Ánh xạ các thành phần giao diện
        btnContinue = findViewById(R.id.btntieptuc);
        btnCalc = findViewById(R.id.btngiaipt);
        btnCancel = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edta);
        editb = findViewById(R.id.edtb);
        editc = findViewById(R.id.edtc);
        txtkq = findViewById(R.id.txtkq);

// Xử lý sự kiện khi nhấn nút "Giải PT"
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ các EditText
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                // Kiểm tra nếu các giá trị không rỗng
                if (!sa.isEmpty() && !sb.isEmpty() && !sc.isEmpty()) {
                    try {
                        int a = Integer.parseInt(sa);
                        int b = Integer.parseInt(sb);
                        int c = Integer.parseInt(sc);
                        String kq = "";
                        DecimalFormat dcf = new DecimalFormat("0.00");

                        // Giải phương trình bậc 2
                        if (a == 0) {
                            if (b == 0) {
                                if (c == 0) {
                                    kq = "PT vô số nghiệm";
                                } else {
                                    kq = "PT vô nghiệm";
                                }
                            } else {
                                kq = "PT có 1 nghiệm, x = " + dcf.format(-c / (double) b);
                            }
                        } else {
                            double delta = b * b - 4 * a * c;
                            if (delta < 0) {
                                kq = "PT vô nghiệm";
                            } else if (delta == 0) {
                                kq = "PT có nghiệm kép x1 = x2 = " + dcf.format(-b / (2.0 * a));
                            } else {
                                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                                kq = "PT có 2 nghiệm: x1 = " + dcf.format(x1) + ", x2 = " + dcf.format(x2);
                            }
                        }

                        // Hiển thị kết quả
                        txtkq.setText(kq);
                    } catch (NumberFormatException e) {
                        txtkq.setText("Vui lòng nhập số hợp lệ!");
                    }
                } else {
                    txtkq.setText("Vui lòng nhập đầy đủ các giá trị a, b, c!");
                }
            }
        });

// Xử lý sự kiện khi nhấn nút "Tiếp tục"
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa trắng các ô nhập liệu
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtkq.setText(""); // Xóa luôn kết quả
                edita.requestFocus(); // Đặt focus về ô nhập a
            }
        });

// Xử lý sự kiện khi nhấn nút "Thoát"
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng ứng dụng
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}