package com.seong.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	
	private String type;   
	private String keyword;
	
	/** 아무것도 안줬을 경우 1페이지 10개 출력*/
	public Criteria() {
		this(1,10); 
	}

	public Criteria(int i, int j) {
		this.pageNum = i;
		this.amount = j;
	}

	public String[] getTypeArr() {
		return type==null ? new String[] {} : type.split("");
	}
	
}
