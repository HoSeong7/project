create table employees(
	id			varchar(10) not null primary key,
	pass		varchar(10) not null,
	name		varchar(24),
	lev			char(1) default 'A',
	enter 		date,
	gender		char(1) default '1',
	phone		varchar(30),
	pictureurl	varchar(50)
);

select * from employees;

insert into employees values("2022122801", "1234", "곽호성", "E", "2022-12-28", "0", "010-0000-0000",null),
							("2022122802", "1234", "임원A", "D", "2022-12-28", "1", "010-1111-1111",null),
							("2022122803", "1234", "팀장A", "B", "2022-12-28", "0", "010-2222-2222",null),
							("2022122901", "1234", "사원A", "A", "2022-12-29", "1", "010-3333-3333",null);
drop table employees;