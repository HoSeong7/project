package com.seong.service;

import java.util.List;

import com.seong.domain.Criteria;
import com.seong.domain.TodoVO;

public interface TodoService {

//
//	public Long register(TodoVO todo);
//	
	public TodoVO get(Long no);
//	
//	public boolean modify(TodoVO todo);
//	
//	public boolean remove(Long no);
	
	public List<TodoVO> getList();
	
//	public List<TodoVO> getList(Criteria cri);
//	
//	public int getTotalCount(Criteria cri);
	
}
