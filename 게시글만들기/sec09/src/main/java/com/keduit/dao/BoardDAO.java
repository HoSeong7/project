package com.keduit.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.keduit.dto.BoardVO;

import util.DBManager;

public class BoardDAO {

	private BoardDAO(){
		
	}
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {	
		return instance;
	}
	
	// 리스트 읽어오기
	public List<BoardVO> selectAllBoards(){
		String sql="select * from board order by num desc";
		List<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO bVO = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement(); // 얘는 쿼리를 날릴 때 sql문을 줌
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				bVO = new BoardVO();
				bVO.setNum(rs.getInt("num"));
				bVO.setPass(rs.getString("pass"));
				bVO.setName(rs.getString("name"));
				bVO.setEmail(rs.getNString("email"));
				bVO.setTitle(rs.getString("title"));
				bVO.setContent(rs.getString("content"));
				bVO.setReadcount(rs.getInt("readcount"));
				bVO.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public void insertBoard(BoardVO bVO) {
		String sql = "insert into board (" + "name, email, pass, title, content) " + "values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVO.getName());
			pstmt.setString(2, bVO.getEmail());
			pstmt.setString(3, bVO.getPass());
			pstmt.setString(4, bVO.getTitle());
			pstmt.setString(5, bVO.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//게시글 상세보기
	public BoardVO selectOneBoardByNum(String num) {
		BoardVO bVO = null;
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;    // 읽어오기 위해 필요
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bVO = new BoardVO();
				bVO.setNum(rs.getInt("num"));
				bVO.setPass(rs.getString("pass"));
				bVO.setName(rs.getString("name"));
				bVO.setEmail(rs.getNString("email"));
				bVO.setTitle(rs.getString("title"));
				bVO.setContent(rs.getString("content"));
				bVO.setReadcount(rs.getInt("readcount"));
				bVO.setWritedate(rs.getTimestamp("writedate"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bVO;
	}
	
	//게시글 수정
	public void updateBoard(BoardVO bVO) {
		String sql = "update board set name=?, email=?, pass=?, title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVO.getName());
			pstmt.setString(2, bVO.getEmail());
			pstmt.setString(3, bVO.getPass());
			pstmt.setString(4, bVO.getTitle());
			pstmt.setString(5, bVO.getContent());
			pstmt.setInt(6, bVO.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount +1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//지우기
	public void deleteBoard(String num) {
		String sql = "delete from board where num= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	}
