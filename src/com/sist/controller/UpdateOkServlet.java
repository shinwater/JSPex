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


@WebServlet("/updateOk.do")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String sname = request.getParameter("sname");
		int shakbun = Integer.parseInt(request.getParameter("shakbun"));
		String smajor = request.getParameter("smajor");
		int syear = Integer.parseInt(request.getParameter("syear"));
		int sage = Integer.parseInt(request.getParameter("sage"));
		String sphone = request.getParameter("sphone");
		String saddress = request.getParameter("saddr1")+" ☆ "+request.getParameter("saddr2");
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
		int result = dao.updateStudent(dto);
		
		PrintWriter out=response.getWriter();
		if(result == 1) {
			out.println("<script>");
			out.println("alert('수정 완료~')");
			out.println("location.href='list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('수정 실패~')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		
	}

}
