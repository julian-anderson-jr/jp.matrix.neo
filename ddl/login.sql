conn poko/poko@xe

declare
tb varchar2(250);
cnt number;
begin
 select count(1) INTO cnt from user_tables where TABLE_NAME = 'USERINFO';
 if cnt > 0 then 
  EXECUTE immediate 'DROP TABLE USERINFO';
 end if;
 select count(1) INTO cnt from user_tables where TABLE_NAME = 'GROUPINFO';
 if cnt > 0 then 
  EXECUTE immediate 'DROP TABLE GROUPINFO';
 end if;
 select count(1) INTO cnt from user_tables where TABLE_NAME = 'PARTS';
 if cnt > 0 then 
  EXECUTE immediate 'DROP TABLE PARTS';
 end if;
 select count(1) INTO cnt from user_tables where TABLE_NAME = 'BUYLIST';
 if cnt > 0 then 
  EXECUTE immediate 'DROP TABLE BUYLIST';
 end if;
end;
/

create table USERINFO
(
	SID varchar2(200) not null
,	PWD varchar2(200) not null
,	GPID number(5,0)
,	LVL number(1,0) default 0
,	LOCKING number(1,0) default 0
,	UPDT date
,	CRDT date
,	constraint PK_USERINFO PRIMARY KEY (SID)
);
INSERT INTO USERINFO(SID,PWD) VALUES ('POKO','$2a$10$lzr4nvX8U/VoC1gwmKxbrO.TITYJTYRIn55DE6Ixp.A4ZRz.Aax2u');
create table GROUPINFO
(
	GPID number(5,0) not null
,	GPNAME nvarchar2(200)
,	constraint PK_GROUPINFO PRIMARY KEY (GPID)
);

insert into GROUPINFO values(1, 'USER');
insert into GROUPINFO values(2, 'ADMIN_USER');
insert into GROUPINFO values(99, 'ADMIN_SYSTEM');
commit;

create table PARTS
(
	PID number(5,0) not null
,	PNAME varchar2(200) not null
,	PRICE number(5,0) default 0
,	constraint PK_PARTS PRIMARY KEY (PID)
);

create table BUYLIST
(
	BID number(5,0) not null
,	SERIAL number(5,0) not null
,	PID number(5,0)
,	constraint PK_BUYLIST PRIMARY KEY (BID, SERIAL)
);
