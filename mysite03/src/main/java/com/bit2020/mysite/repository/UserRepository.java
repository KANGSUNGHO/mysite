package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bit2020.mysite.vo.UserVo;


@Repository
public class UserRepository {
	public boolean save(UserVo vo) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql =
			"insert into user values(null, ?, ?, password(?),?, now())";
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getEmail());
			pstmt.setString(3,vo.getPassword());
			pstmt.setString(4,vo.getGender());
			
			// 4. SQL 실행 
			int count = pstmt.executeUpdate(); // 리턴값으로 인서트 개수가 나옴
			result = (count == 1);


		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");
	
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("드라이버 로딩 성공");
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		
		return connection;
	}
	public UserVo findByNo(Long no) {
		UserVo result = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql =
			"select no, name, email, gender from user where no = ?";
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setLong(1,no);
			
			// 4. SQL 실행 
			rs  = pstmt.executeQuery(); 
			
			// 5. 결과 가져오기
			if(rs.next()){
				Long no1 = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String gender = rs.getString(4);
				
				result = new UserVo();
				result.setNo(no1);
				result.setName(name);
				result.setEmail(email);
				result.setGender(gender);
			}

		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql =
			"select no, name from user where email =? and password=password(?)";
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			// 4. SQL 실행 
			rs  = pstmt.executeQuery(); 
			
			// 5. 결과 가져오기
			if(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}

		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean update(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql =
			"update user set name=?,password=password(?) where no=?";
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPassword());
			pstmt.setLong(3,vo.getNo());
			
			// 4. SQL 실행 
			int count = pstmt.executeUpdate(); // 리턴값으로 인서트 개수가 나옴
			result = (count == 1);


		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
}
