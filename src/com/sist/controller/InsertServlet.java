package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.StudentDAO;
import com.sist.model.StudentDTO;

@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String sname = request.getParameter("sname").trim();
		int shakbun = Integer.parseInt(request.getParameter("shakbun").trim());
		String smajor = request.getParameter("smajor").trim();
		int syear = Integer.parseInt(request.getParameter("syear").trim());
		int sage = Integer.parseInt(request.getParameter("sage").trim());
		String sphone = request.getParameter("sphone").trim();
		String saddress = request.getParameter("saddr1") + " ☆ " + request.getParameter("saddr2");
		String sdate = request.getParameter("sdate");

		StudentDTO dto = new StudentDTO();
		dto.setSname(sname);
		dto.setShakbun(shakbun);
		dto.setSmajor(smajor);
		dto.setSyear(syear);
		dto.setSage(sage);
		dto.setSphone(sphone);
		dto.setSaddress(saddress);
		dto.setSdate(sdate);

		StudentDAO dao = new StudentDAO();
		int res = dao.insertStudent(dto);

		PrintWriter out = response.getWriter();
		if (res == 1) {
			response.sendRedirect("list.do");
		} else {
			out.println("<script>");
			out.println("alert('추가에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
