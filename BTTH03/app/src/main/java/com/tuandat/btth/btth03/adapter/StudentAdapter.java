package com.tuandat.btth.btth03.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuandat.btth.btth03.R;
import com.tuandat.btth.btth03.entities.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        if (student.getGender().equals("Nữ")) {
            holder.imgStudent.setImageResource(R.drawable.female);
        }
        else {
            holder.imgStudent.setImageResource(R.drawable.male);
        }

        holder.tvStudentName.setText(student.getFull_name().getLast() + " " + student.getFull_name().getMidd() + " " + student.getFull_name().getFirst());
        holder.tvStudentID.setText(student.getId());
        holder.tvGpa.setText(String.valueOf(student.getGpa()));
        // Xử lý sự kiện khi click vào item để hiển thị chi tiết
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển dữ liệu sang Activity khác hoặc hiển thị chi tiết trong Dialog
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName, tvStudentID, tvGpa;
        ImageView imgStudent;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.textViewName);
            tvStudentID = itemView.findViewById(R.id.textViewId);
            imgStudent = itemView.findViewById(R.id.imageViewStudent);
            tvGpa = itemView.findViewById(R.id.textViewGpa);
        }
    }
}
