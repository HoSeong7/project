package com.seong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.seong.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/todo/*")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService service;
	
	@GetMapping("/index")
	public void index3(Model model) {
		log.info("------list-----");
		model.addAttribute("todo", service.getList());
		
	
		
//		int total = service.getTotalCount(cri);
//		log.info("-----total-----" + total);
//		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
}
