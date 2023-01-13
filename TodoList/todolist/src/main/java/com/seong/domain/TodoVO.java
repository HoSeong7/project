package com.seong.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TodoVO {

	private Long no;
	private String title;
	private String content;
	private String mycontent;
	private int clear;
	private String startDate;
	private String endDate;
	private Date   regDate;
	private Date   updateDate;
	
}


/*title   제목 
content   내용
mycontent  기록내용
clear   성공,실패 0=도전중 1=성공 2=실패
startDate 시작날짜
endDate  끝나는 날짜
regDate   만든날짜
updateDate  수정날짜 */