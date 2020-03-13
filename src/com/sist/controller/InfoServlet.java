package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;


@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shakbun=Integer.parseInt(request.getParameter("shakbun"));
		
		//선택한 학생의 전체정보 메서드 호출
		StudentDAO dao = new StudentDAO();
		StudentDTO dto =dao.getInfo(shakbun);
		
		request.setAttribute("list", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_info.jsp");
		rd.forward(request, response);
	}

}
