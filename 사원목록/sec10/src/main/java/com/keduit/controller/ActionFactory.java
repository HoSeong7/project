package com.keduit.controller;

import com.keduit.controller.action.Action;

import com.keduit.controller.action.EmployeesDeleteAction;
import com.keduit.controller.action.EmployeesListAction;
import com.keduit.controller.action.EmployeesUpdateAction;
import com.keduit.controller.action.EmployeesUpdateFormAction;
import com.keduit.controller.action.EmployeesViewAction;
import com.keduit.controller.action.EmployeesWriteAction;
import com.keduit.controller.action.EmployeesWriteFormAction;
import com.keduit.controller.action.employeesCheckFormAction;
import com.keduit.controller.action.employeesCheckPassAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {
		super();
	};
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory 에서 커맨드를 받음 : " + command);
		
		if(command.equals("employees_list")) {
			action = new EmployeesListAction();
		}else if(command.equals("employees_view")) {
			action = new EmployeesViewAction();
		}else if(command.equals("employees_write_form")) {
			action = new EmployeesWriteFormAction();
		}else if(command.equals("employees_write")) {
			action = new EmployeesWriteAction();
		}else if(command.equals("employees_delete")) {
			action = new EmployeesDeleteAction();
		}else if(command.equals("employees_check_pass_form")) {
			action = new employeesCheckFormAction();
		}else if(command.equals("employees_check_pass")) {
			action = new employeesCheckPassAction();
		}else if(command.equals("employees_update")) {
			action = new EmployeesUpdateAction();
		}else if(command.equals("employees_update_form")) {
			action = new EmployeesUpdateFormAction();
		}
		
		return action;
	}

}
