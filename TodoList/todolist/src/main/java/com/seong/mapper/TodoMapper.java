package com.seong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.seong.domain.Criteria;
import com.seong.domain.TodoVO;

public interface TodoMapper {

	@Select("select sysdate from dual")
	public String getTime();
	
	
	//@Select("select * from tbl_board order by bno DESC")
	public List<TodoVO> getList();
	
//	public List<TodoVO> getListWithPaging(Criteria cri);
	
//	public void insert(TodoVO todo);
//	
//	public int insertSelectKey(TodoVO todo);
//	
	public TodoVO read(Long no);
//
//	public int delete(Long no);
//	
//	public int update(TodoVO todo);
//	
//	public int getTotalCount(Criteria cri);
	
}
