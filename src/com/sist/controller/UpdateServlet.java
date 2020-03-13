package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hakbun = Integer.parseInt(request.getParameter("hakbun"));
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = dao.getInfo(hakbun);
		
		request.setAttribute("update",dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_update.jsp");
		rd.forward(request, response);
	}
}
