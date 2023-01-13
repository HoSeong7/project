package com.seong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seong.domain.TodoVO;
import com.seong.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@ToString
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	
	private final TodoMapper mapper;

	@Override
	public List<TodoVO> getList(){
		log.info("-----getList" );
		return mapper.getList();
	}
	
//	@Override
//	public List<TodoVO> getList(Criteria cri) {
//		log.info("-----getList" + cri);
//		
//		return mapper.getListWithPaging(cri);
//	}

//	@Override
//	public Long register(TodoVO todo) {
//		log.info("-----register-----" + todo);
//		int result = mapper.insertSelectKey(todo);
//		log.info("-----게시물등록상태 : " + result);
//		return (todo).getNo();
//	}

	@Override
	public TodoVO get(Long no) {
		log.info("-----get------" + no);
		return mapper.read(no);
	}
//
//	@Override
//	public boolean modify(TodoVO todo) {
//		log.info("-----modify-----" + todo);
//		
//		return mapper.update(todo)==1;
//	}
//
//	@Override
//	public boolean remove(Long no) {
//		log.info("-----remove : " + no);
//		return mapper.delete(no)==1;
//	}
//
//	@Override
//	public int getTotalCount(Criteria cri) {
//		log.info("-----get total-----");
//		return mapper.getTotalCount(cri);
//	}
	
	

}
