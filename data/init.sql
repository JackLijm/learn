drop table sysuser;
create table sysuser(
id integer not null primary key,
username varchar2(50) ,
password varchar2(500) not null,
enabled  varchar2(1) null);

insert into sysuser values(1,'lijm','123','1');
insert into sysuser values(2,'szkm','123','0');

DROP  table sysrole;
create table sysrole(
id integer not null primary key,
rolename varchar2(50));

insert into sysrole values(1,'admin');
insert into sysrole values(2,'teacher');
insert into sysrole values(3,'student');

DROP  table syspermission;
create table syspermission(
id integer not null primary key,
permissionname varchar2(50),
description varchar2(500),
url varchar2(500),
pid integer);

insert into syspermission values(1,'ADMIN','管理员','','');
insert into syspermission values(2,'GUEST','访客','','');
insert into syspermission values(3,'ADD','增加','','');
insert into syspermission values(4,'DEL','删除','','');
insert into syspermission values(5,'SELECT','查看','','');

DROP  table user_role;
create table user_role(
id integer not null primary key,
userid INTEGER,
roleid INTEGER);

insert into role_permission values(1,1,3);
insert into role_permission values(2,1,4);
insert into role_permission values(3,1,5);
insert into role_permission values(4,2,5);

DROP  table role_permission;
create table role_permission(
id integer not null primary key,
roleid INTEGER,
permissionid INTEGER);


insert into user_role values(1,1,1);
insert into user_role values(2,2,2);

--经过以上初始化，有了基本的权限赋值


-- Create sequence
create sequence SEQ_AUTH_ID
minvalue 1
maxvalue 999999999999
start with 340
increment by 1
cache 20;