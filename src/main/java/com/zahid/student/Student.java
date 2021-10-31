package com.zahid.student;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String department;
    private List<String> courseList;
    
    @Override
    public String toString() {
        return String.format("%s[department=%s, courseList=%s]", name, department, courseList);
    }
}
