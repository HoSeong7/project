create table board(
	num				int(5) primary key not null auto_increment, 
	pass			varchar(30),
	name			varchar(30),
	email			varchar(30),
	title			varchar(50),
	content			varchar(1000),
	readcount		int(4) default 0,
	writedate		datetime default current_timestamp on update current_timestamp
	
	);

select * from board;
	
insert into board values(null, "1234", "홍길동", "hong@abc.com", "게시글1번", "게시글1번 홍길동이 남김", 0, 20221226),
						(null, "1234", "둘리", "hoi@abc.com", "게시글2번", "게시글2번 둘리 ㄴ마김", 0, 20221226);
						
						
