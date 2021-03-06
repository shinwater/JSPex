<%@page import="com.sist.model.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDTO dto=(StudentDTO)request.getAttribute("update");
	String address = dto.getSaddress();
	
	int idx = address.indexOf("☆");
	
	String addr1 = address.substring(0,idx);
	String addr2 = address.substring(idx+1);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                
                } else {
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</head>
<body>
	<div align="center">
		<h3>학생 정보 수정</h3>
		<hr width="70%" color="hotpink"/>
		<form action="updateOk.do" method="post">
			<table border="0" cellspacing="0" width="800">
				<tr>
					<th align="right" width="100">이 름 :&ensp;</th>
					<td><input type="text" name="sname" size="60" value="<%=dto.getSname() %>" required/></td>
				</tr>
				<tr>
					<th align="right">학 번 :&ensp;</th>
					<td><input type="text" name="shakbun" size="60" value="<%=dto.getShakbun() %>" readonly required/></td>
				</tr>
				<tr>
					<th align="right">학 과 :&ensp;</th>
					<td><input type="text" name="smajor" size="60" value="<%=dto.getSmajor() %>" required/></td>
				</tr>
				<tr>
					<th align="right">학 년 :&ensp;</th>
					<td><input type="text" name="syear" size="60" value="<%=dto.getSyear()%>" required/></td>
				</tr>
				<tr>
					<th align="right">나 이 :&ensp;</th>
					<td><input type="text" name="sage" size="60" value="<%=dto.getSage() %>" required/></td>
				</tr>
				<tr>
					<th align="right"></th>
					<td><font size="1" color="darkgray">연락처는 000-0000-0000 꼴로 입력하세요.</font></td>
				</tr>
				<tr>
					<th align="right">연 락 처 :&ensp;</th>
					<td><input type="text" name="sphone" size="60" value="<%=dto.getSphone() %>" required/></td>
				</tr>
				
				<tr>
					<th align="right"></th>
					<td></td>
				</tr>
				
				<tr>
					<th align="right">주 소 :&ensp;</th>
					<td>
					<input type="text" id="sample6_postcode" size="30" placehorder="우편번호"/>
					<input type="button" value="우편번호" onclick="sample6_execDaumPostcode()">
					</td>
				</tr>
					<%! 
						
					%>
				<tr>	
					<th align="right"></th>
					 <td><input type="text" id="sample6_address" name="saddr1" size="60" value="<%=addr1%>" required /></td>
				</tr>
				<tr>
					<th align="right">상 세 주 소 :&ensp;</th>
					 <td><input type="text" id="sample6_detailAddress" name="saddr2" size="50" value="<%=addr2 %>" required/></td>
				</tr>
				
				<tr>
					<th align="right"></th>
					<td><font size="1" color="darkgray">입학일은 20/00/00 꼴로 입력해주세요.</font></td>
				</tr>
				
				<tr>
					<th align="right">입 학 일 :&ensp;</th>
					<td><input type="text" name="sdate" size="60" value="<%=dto.getSdate().substring(0,10)%>"required/></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<a href="list.do"><font size="2">[목록으로]</font></a> &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="수정">&nbsp;&nbsp;
						<input type="reset" value="취소">
						
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>