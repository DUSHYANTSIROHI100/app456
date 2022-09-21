package com.durgasoft.services;

import java.util.List;

import com.durgasodt.beans.Student;

public interface StudentServices {
 public void addStudent(Student std);
 public List<Student> getAllStudents();
}
