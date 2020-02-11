package com.douzone.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.douzone.emaillist.vo.EmaillistVo;

public class EmaillistDao {

	public boolean insert(EmaillistVo vo) {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
		
			int count = pstmt.executeUpdate();
			
			result = count ==1;
			
			
		}catch (SQLException e) {
			System.out.println("ERROR:"+e);
		}finally {
			//6.자원정리
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<EmaillistVo> findAll(){
		List<EmaillistVo> result =new ArrayList<EmaillistVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			String sql= "select first_name,last_name,email from emaillist";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//5 결과 가져오기 
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName=rs.getString(2);
				String email=rs.getString(3);
				
				EmaillistVo vo = new EmaillistVo();
				
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				result.add(vo);
				
			}
		
		}catch (SQLException e) {
			System.out.println("ERROR:"+e);
		}finally {
			//6.자원정리
			try {
				if(rs != null) {
					rs.close();
				}			
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			return result;
	}
	
	private Connection getConnection() throws SQLException{
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://127.0.0.1:3306/bookshop";
			conn=DriverManager.getConnection(url,"bookshop","bookshop");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+e);
		}
		
		return conn;
	}
	
}
