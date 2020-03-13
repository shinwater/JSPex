<%@page import="com.sist.model.StudentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<StudentDTO> list = (List<StudentDTO>)request.getAttribute("List");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="70%" color="pink"/>
		
		
		<table border="0" cellspacing="0" width="400">
			
			
			<tr>
				<th>이 름</th><th>학 번</th><th>학 과</th>
			</tr>
				<% 
				if(list.size() != 0 ){
					for(int i=0; i<list.size();i++){
						StudentDTO dto = list.get(i);
				%>		<tr>
							<td align="center"><a href="info.do?shakbun=<%=dto.getShakbun()%>"><font color="darkgray"><%=dto.getSname()%></font></a></td>
							<td align="center"><%=dto.getShakbun()%></td>
							<td align="center"><%=dto.getSmajor()%></td>
						</tr><%
					}
				}else{%>
					<tr>
						<td colspan="3" align="center">
							학생이 없습니다.
						</td>
					</tr>
			<%	}%>
		</table>
		
		<br/>
		<hr width="70%" color="pink"/>
		<input type="button" value="추가"
			onclick="location.href='student_add.jsp'"/>
	</div>
</body>
</html>