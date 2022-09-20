package com.durgasoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasodt.beans.Student;
import com.durgasoft.services.StudentService;
import java.util.List;



/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			Student std = new Student();
			std.setSid(sid);
			std.setSname(sname);
			std.setSaddr(saddr);
			
			StudentService stdService=new StudentService();
			stdService.addStudent(std);
			
			
			List<Student> stdList=stdService.getAllStudent();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2 color='color:red;' align='center'>Durga Software Solutions</h2>");
			out.println("<h2 color='color:red;' align='center'>Student Details</h2>");
			out.println("<table align='center' bgcolor='lightyellow'>");
			out.println("<tr><th>SID</th><th>SNAME</th><th>SADDR</th></tr>");
			for(Student s : stdList){
			out.println("<tr>");
			out.println("<td>" + s.getSid()+"</td>");
			out.println("<td>" + s.getSname()+"</td>");
			out.println("<td>" + s.getSaddr()+"</td>");
			out.println("<tr>");
			}
			out.println("</table></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/AddForm.html");
			rd.include(request, response);
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
			}

