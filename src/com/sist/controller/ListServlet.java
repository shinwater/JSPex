package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;


@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> list = dao.getList();
		
		request.setAttribute("List", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_list.jsp");
		rd.forward(request, response);
	}

}
