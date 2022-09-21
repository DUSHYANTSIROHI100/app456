package com.durgasoft.servlets;

import com.durgasodt.beans.Student;


import java.util.List;

public interface StudentServices {

	public void addStudent(Student std);
	public List<Student> getAllStudent();
}
