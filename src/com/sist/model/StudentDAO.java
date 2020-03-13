package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	Connection con = null; // DB와 연결
	PreparedStatement pstmt = null;// DB에 sql문을 전송하는 객체
	ResultSet rs = null; // sql문을 실행 후 그 결과값을 가진 객체

	String sql = null; // 쿼리문을 저장할 문자열 객체.

	public StudentDAO() {

		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "genie";
		String password = "1234";

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 생성자~~~끝~~~
	
	
	//학생리스트에서 이름,학번,학과를 가져와서 ArrayList에 저장하는 메서드
	public List<StudentDTO> getList(){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		try {
			sql = "select * from student";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setSname(rs.getString("sname"));
				dto.setShakbun(rs.getInt("shakbun"));
				dto.setSmajor(rs.getString("smajor"));
				
				list.add(dto);
			}
			
			con.close();pstmt.close();rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}//getList() 끝
	
	//학생리스트에서 이름을 선택한 학생의 학번으로  
	//해당학생의 모든 정보를 저장하는 메서드
	public StudentDTO getInfo(int hakbun){
		StudentDTO dto = new StudentDTO();

		try {
			sql = "select * from student where shakbun=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setSname(rs.getString("sname"));
				dto.setShakbun(rs.getInt("shakbun"));
				dto.setSmajor(rs.getString("smajor"));
				dto.setSyear(rs.getInt("syear"));
				dto.setSage(rs.getInt("sage"));
				dto.setSphone(rs.getString("sphone"));
				dto.setSaddress(rs.getString("saddress"));
				dto.setSdate(rs.getString("sdate"));
		
			}
			
			con.close();pstmt.close();rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}//getInfo() 끝
	
	
	//DB에 새로운 학생의 정보를 추가하는 메서드
	public int insertStudent(StudentDTO dto) {
		int result=0;
		
		
		try {
			sql="insert into student values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getShakbun());
			pstmt.setString(3, dto.getSmajor());
			pstmt.setInt(4, dto.getSyear());
			pstmt.setInt(5, dto.getSage());
			pstmt.setString(6, dto.getSphone());
			pstmt.setString(7, dto.getSaddress());
			pstmt.setString(8, dto.getSdate());
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//선택한 학생의 정보를 수정하는 메서드 
	
	public int updateStudent(StudentDTO dto) {
		int result = 0;
		
		try {
			sql="update student set sname=?, smajor=?, syear=?, sage=?, sphone=?, saddress=?, sdate=? where shakbun=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getSmajor());
			pstmt.setInt(3, dto.getSyear());
			pstmt.setInt(4, dto.getSage());
			pstmt.setString(5, dto.getSphone());
			pstmt.setString(6, dto.getSaddress());
			pstmt.setString(7, dto.getSdate());
			pstmt.setInt(8, dto.getShakbun());
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	//선택한 학생의 정보를 DB에서 지우는 메서드 
	public int deleteStudent(int hakbun) {
		
		int result=0;
		try {
			sql="delete from student where shakbun=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			result=pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//테이블에서 학생을 검색하는 메서드 
}
