create table customer(
id        number constraint customer_id_pk primary key,
name      varchar2(50) not null,
gender    varchar2(3) default '남',
email     varchar2(50),
phone     varchar2(13)
);


create sequence seq_customer
start with 1 increment by 1;

insert into customer(id, name, email, phone)
values (seq_customer.nextval, '홍길동'
			, 'hong@naver.com', '010-1234-5678');
commit;

select * from customer; 


create or replace trigger trg_customer
	before insert on customer
	for each row
begin
	select seq_customer.nextval into :new.id from dual;
end;
/

insert into customer(name, email)
values ('심청', 'sim@daum.net');
commit;
