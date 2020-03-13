<%@page import="com.sist.model.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDTO dto =(StudentDTO)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 해당 학생의 모든정보를 출력하는 테이블,목록으로 수정 삭제 버튼 만들기! -->
		<div align="center">
		
			<h3><%=dto.getSname() %>의 정보</h3>
			<hr width="70%" color="pink"/>
			<table border="0" cellspacing="0" width="600">
				<% 
					if(dto != null) {
				%>
						<tr>
							<th align="right" width="100"> 이 름 :&ensp;</th>
							<td><%=dto.getSname() %></td>
						</tr>
						<tr>
							<th align="right" width="100"> 학 번 :&ensp;</th>
							<td><%=dto.getShakbun()%></td>
						</tr>
						<tr>
							<th align="right" width="100"> 학 과 :&ensp;</th>
							<td><%=dto.getSmajor() %></td>
						</tr>
						<tr>
							<th align="right" width="100"> 학 년 :&ensp;</th>
							<td><%=dto.getSyear() %></td>
						</tr>
						<tr>		
							<th align="right" width="100"> 나 이 :&ensp;</th>
							<td><%=dto.getSage() %></td>
						</tr>
						<tr>
							<th align="right" width="100"> 연 락 처 :&ensp;</th>
							<td><%=dto.getSphone() %></td>
						</tr>
						<tr>
							<th align="right" width="100"> 주 소 :&ensp;</th>
							<td><%=dto.getSaddress()%></td>
						</tr>
						<tr>
							<th align="right" width="100"> 날 짜 :&ensp;</th>
							<td><%=dto.getSdate().substring(0,10) %></td>
						</tr>
				<%
					}else {
				%>	
						<tr>
							<td colspan="2" align="center">
								<h3>검색된 레코드가 없습니다.</h3>
							</td>
						</tr>
				<% 		
					}
				%>
				
				<tr>
					<td colspan="2" align="center">
						<a href="list.do" style="color:darkgray">[목록으로]</a>
						<a href="update.do?hakbun=<%=dto.getShakbun()%>" style="color:darkgray">[수정]</a>
						<a href="delete.do?hakbun=<%=dto.getShakbun()%>" style="color:darkgray">[삭제]</a>

				
				</tr>
				
			</table>
		
		</div>
</body>
</html>