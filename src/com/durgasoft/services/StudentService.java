package com.durgasoft.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.durgasodt.beans.Student;
import com.durgasoft.factory.ConnectionFactory;
import com.durgasoft.servlets.StudentServices;



public class StudentService implements StudentServices {

	
	public void addStudent(Student std){
	try {
		Connection con=ConnectionFactory.getConnection();
		Statement st= con.createStatement();
	st.executeUpdate("insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public List<Student> getAllStudent(){
		List<Student> stdList=null;
	try {
		Connection con=ConnectionFactory.getConnection();
		Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from student");
	stdList = new ArrayList<Student>();
	while(rs.next()){
	Student std=new Student();
	std.setSid(rs.getString("SID"));
	std.setSname(rs.getString("SNAME"));
	std.setSaddr(rs.getString("SADDR"));
	stdList.add(std);
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return stdList;
	}
}
