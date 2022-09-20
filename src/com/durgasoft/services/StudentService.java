package com.durgasoft.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.durgasodt.beans.Student;



public class StudentService {

	Connection con;
	Statement st;
	ResultSet rs;

	public StudentService(){
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "xe", "123");
	st=con.createStatement();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public void addStudent(Student std){
	try {
	st.executeUpdate("insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public List<Student> getAllStudent(){
		List<Student> stdList=null;
	try {
	rs=st.executeQuery("select * from student");
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
