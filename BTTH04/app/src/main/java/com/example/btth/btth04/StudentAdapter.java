package com.example.btth.btth04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btth.btth04.entities.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<Student> studentList;

    // Constructor
    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Get current student
        Student student = studentList.get(position);

        // Bind data to the views
        holder.textViewId.setText("MSV: "+ String.valueOf(student.getId()));
        holder.textViewName.setText("Ho ten: "+student.getName());
        holder.textViewClass.setText("Lop: "+student.getStudentClass());
        holder.textViewGPA.setText("Diem trung binh: "+String.valueOf(student.getGpa()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    // ViewHolder class to hold the views
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewName, textViewClass, textViewGPA;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewClass = itemView.findViewById(R.id.textViewClass);
            textViewGPA = itemView.findViewById(R.id.textViewGPA);
        }
    }
}

