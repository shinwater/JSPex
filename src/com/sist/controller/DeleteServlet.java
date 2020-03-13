package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;


@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int shakbun = Integer.parseInt(request.getParameter("hakbun"));
		StudentDAO dao = new StudentDAO();
		int result = dao.deleteStudent(shakbun);
		
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.println("<script>");
			out.println("alert('정보 삭제 성공')");
			out.println("location.href='list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('정보 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
