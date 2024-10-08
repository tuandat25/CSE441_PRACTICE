package com.tuandat.btth.btth03.entities;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private FullName full_name;
    private String gender;
    private String birth_date;
    private String email;
    private String address;
    private String major;
    private double gpa;
    private int year;

    // Tạo getter và setter cho các trường
    // Inner class đại diện cho Full Name
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FullName {
        private String first;
        private String last;
        private String midd;

        // Getter và setter
    }
}