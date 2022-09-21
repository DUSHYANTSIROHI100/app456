package com.durgasoft.factory;

import com.durgasodt.beans.Student;
import com.durgasoft.services.StudentService;
import com.durgasoft.servlets.StudentServices;


public class StudentServiceFactory {
private static StudentServices stdService;
static {
	stdService = new StudentService();
}
public static StudentServices getStudentService() {
	return stdService;
}
}
