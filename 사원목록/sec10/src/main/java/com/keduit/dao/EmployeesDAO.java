package com.keduit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.keduit.dto.EmployeesVO;


import util.DBManager;

public class EmployeesDAO {

	private EmployeesDAO() {}
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	//읽어오기
	public List<EmployeesVO> selectAll(){
		String sql = "select * from employees order by lev desc,name";
		List<EmployeesVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeesVO eVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				eVO = new EmployeesVO();
				eVO.setId(rs.getString("id"));
				eVO.setPass(rs.getString("pass"));
				eVO.setName(rs.getString("name"));
				eVO.setLev(rs.getString("lev"));
				eVO.setEnter(rs.getString("enter"));
				eVO.setGender(rs.getString("gender"));
				eVO.setPhone(rs.getString("phone"));
				list.add(eVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return list;
	}

	//상세보기 페이지 연결
	public EmployeesVO selectOneByNum(String id) {
		EmployeesVO eVO = null;
		String sql = "select * from employees where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				eVO = new EmployeesVO();
				eVO.setId(rs.getString("id"));
				eVO.setPass(rs.getString("pass"));
				eVO.setName(rs.getString("name"));
				eVO.setLev(rs.getString("lev"));
				eVO.setEnter(rs.getString("enter"));
				eVO.setGender(rs.getString("gender"));
				eVO.setPhone(rs.getString("phone"));
				eVO.setPictureurl(rs.getString("pictureurl"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return eVO;
	}
	
	//신규 가입자 
	public void insertEmployees(EmployeesVO eVO) {

		String sql = "insert into employees (id,pass,name,lev,gender,phone,pictureurl,enter) values(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVO.getId());
			pstmt.setString(2, eVO.getPass());
			pstmt.setString(3, eVO.getName());
			pstmt.setString(4, eVO.getLev());
			pstmt.setString(5, eVO.getGender());
			pstmt.setString(6, eVO.getPhone());
			pstmt.setString(7, eVO.getPictureurl());
			pstmt.setString(8, eVO.getEnter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	//삭제하기
	public void deleteEmployees(String id) {
		String sql = "delete from employees where id= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	//업데이트하기
	public void updateEmployees(EmployeesVO eVO) {

		String sql = "update employees set pass=?,name=?,lev=?,gender=?,phone=?,pictureurl=?,enter=? where id=? ";		
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVO.getPass());
			pstmt.setString(2, eVO.getName());
			pstmt.setString(3, eVO.getLev());
			pstmt.setString(4, eVO.getGender());
			pstmt.setString(5, eVO.getPhone());
			pstmt.setString(6, eVO.getPictureurl());
			pstmt.setString(7, eVO.getEnter());
			pstmt.setString(8, eVO.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	
}
