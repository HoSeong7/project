package com.keduit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.keduit.dto.MemberVO;

import util.DBManager;


public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		conn = ds.getConnection();
		
		return conn;
	}
	
	//사용자 인증시 처리하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();   // 읽기
			
			if(rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					return 1;
				}else {
					return 0;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

	//아이디로 회원 정보를 가져오는 메소드
	public MemberVO getMember(String userid) {
		MemberVO mVO = null;
		String sql = "select * from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;    //읽어오기 위해
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVO = new MemberVO();
				mVO.setName(rs.getString("name"));
				mVO.setUserid(rs.getString("userid"));
				mVO.setPwd(rs.getString("pwd"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return mVO;
	}

	public int updateMember(MemberVO mVO) {
		int result = -1;
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection(); // conn을 얻어옴
			pstmt = conn.prepareStatement(sql); // pstmt를 만듬
			pstmt.setString(1, mVO.getPwd());
			pstmt.setString(2, mVO.getEmail());
			pstmt.setString(3, mVO.getPhone());
			pstmt.setInt(4, mVO.getAdmin());
			pstmt.setString(5, mVO.getUserid());
			
			result = pstmt.executeUpdate();  // 적용시키기 업데이트기 때문에 인트타입으로 넣어줌
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
		return result;
	}

	public int conformID(String userid) {
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
		
		if(rs.next()) {
			result = 1;
		} else {
			result = -1;
		}
		}catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 
			return result;
	}
	
	public int insertMember(MemberVO mVO) {
		int result = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getUserid());
			pstmt.setString(3, mVO.getPwd());
			pstmt.setString(4, mVO.getEmail());
			pstmt.setString(5, mVO.getPhone());
			pstmt.setInt(6, mVO.getAdmin());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}

}
