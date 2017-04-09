drop table if exists book;

drop table if exists book_publisher;

drop table if exists contact;

drop table if exists contractor;

drop table if exists customer;

drop table if exists employee;

drop table if exists family_member;

drop table if exists good;

drop table if exists organization;

drop table if exists party;

drop table if exists party_role_type;

drop table if exists person;

drop table if exists publisher;

drop table if exists service;

drop table if exists student;

drop table if exists teacher;

drop table if exists test_party;

drop table if exists test_person;

create table book
(
   BOOK_ID              bigint not null,
   NAME                 varchar(40),
   primary key (BOOK_ID)
);

create table publisher
(
   PUBLISHER_ID         bigint not null,
   NAME                 varchar(40),
   primary key (PUBLISHER_ID)
);

create table book_publisher
(
   BOOK_ID              bigint,
   PUBLISHER_ID         bigint,
   PUBLISHED_DATE       date,
   constraint FK_Relationship_3 foreign key (BOOK_ID)
      references book (BOOK_ID) on delete restrict on update restrict,
   constraint FK_Relationship_4 foreign key (PUBLISHER_ID)
      references publisher (PUBLISHER_ID) on delete restrict on update restrict
);

create table party
(
   PARTY_ID             bigint not null,
   primary key (PARTY_ID)
);

alter table party comment '当事人';

create table party_role_type
(
   ROLE_TYPE_ID         bigint not null,
   DESCRIPTION          varchar(255),
   primary key (ROLE_TYPE_ID)
);

alter table party_role_type comment '当事人角色类型';

create table contact
(
   PARTY_ROLE_ID        bigint,
   FROM_DATE            date,
   DUE_DATE             date comment '终止日期',
   PARTY_ID             bigint not null,
   ROLE_TYPE_ID         bigint not null,
   primary key (PARTY_ID, ROLE_TYPE_ID),
   constraint FK_r_5 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict,
   constraint FK_r_6 foreign key (ROLE_TYPE_ID)
      references party_role_type (ROLE_TYPE_ID) on delete restrict on update restrict
);

alter table contact comment '联系人';

create table contractor
(
   PARTY_ROLE_ID        bigint,
   FROM_DATE            date,
   DUE_DATE             date,
   PARTY_ID             bigint not null,
   ROLE_TYPE_ID         bigint not null,
   primary key (PARTY_ID, ROLE_TYPE_ID),
   constraint FK_r_7 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict,
   constraint FK_r_8 foreign key (ROLE_TYPE_ID)
      references party_role_type (ROLE_TYPE_ID) on delete restrict on update restrict
);

alter table contractor comment '1.立约人，订约人
2.承包人，承包商；承揽人';

create table customer
(
   PARTY_ID             bigint not null,
   ROLE_TYPE_ID         bigint not null,
   PARTY_ROLE_ID        bigint,
   FROM_DATE            date,
   DUE_DATE             date comment '终止日期',
   primary key (PARTY_ID, ROLE_TYPE_ID),
   constraint FK_r_1 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict,
   constraint FK_r_2 foreign key (ROLE_TYPE_ID)
      references party_role_type (ROLE_TYPE_ID) on delete restrict on update restrict
);

alter table customer comment '客户';

create table employee
(
   PARTY_ROLE_ID        bigint,
   PARTY_ID             bigint not null,
   ROLE_TYPE_ID         bigint not null,
   FROM_DATE            date,
   DUE_DATE             date,
   primary key (PARTY_ID, ROLE_TYPE_ID),
   constraint FK_r_9 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict,
   constraint FK_r_10 foreign key (ROLE_TYPE_ID)
      references party_role_type (ROLE_TYPE_ID) on delete restrict on update restrict
);

alter table employee comment '雇员';

create table family_member
(
   PARTY_ROLE_ID        bigint,
   FROM_DATE            date,
   DUE_DATE             date comment '终止日期',
   PARTY_ID             bigint not null,
   ROLE_TYPE_ID         bigint not null,
   primary key (PARTY_ID, ROLE_TYPE_ID),
   constraint FK_r_3 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict,
   constraint FK_r_4 foreign key (ROLE_TYPE_ID)
      references party_role_type (ROLE_TYPE_ID) on delete restrict on update restrict
);

alter table family_member comment '家庭成员';

create table good
(
   PRODUCT_ID           bigint not null,
   PRODUCT_NAME         varchar(40),
   INTRODUCTION_DATE    date,
   PRICE                varchar(20) default '0',
   PRODUCT_DETAILS      varchar(100),
   PRODUCT_DESCRIPTION  varchar(255),
   primary key (PRODUCT_ID)
);

create table organization
(
   PARTY_ID             bigint not null,
   NAME                 varchar(40) not null,
   primary key (PARTY_ID),
   constraint FK_Relationship_7 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict
);

alter table organization comment '组织';

create table person
(
   PARTY_ID             bigint not null,
   CURRENT_NAME         varchar(40) not null,
   GENDER               varchar(1) comment '性别',
   BIRTH_DATE           date comment '出生日期',
   HEIGHT               varchar(40) comment '身高',
   WEIGHT               varchar(40) comment '体重',
   MARITAL_STATUS       varchar(1) comment '婚姻状况',
   COMMENTS             varchar(255),
   primary key (PARTY_ID),
   constraint FK_Relationship_5 foreign key (PARTY_ID)
      references party (PARTY_ID) on delete restrict on update restrict
);

alter table person comment '人员';

create table service
(
   PRODUCT_ID           bigint not null,
   PRODUCT_NAME         varchar(40),
   INTRODUCTION_DATE    date,
   PRICE                varchar(20) default '0',
   PRODUCT_DETAILS      varchar(100),
   PRODUCT_DESCRIPTION  varchar(255),
   primary key (PRODUCT_ID)
);

create table student
(
   STUDENT_ID           bigint not null,
   NUMBER_OF_PAGES      bigint,
   primary key (STUDENT_ID)
);

create table teacher
(
   TEACHER_ID           bigint not null,
   NAME                 varchar(40),
   primary key (TEACHER_ID)
);

create table test_party
(
   PARTY_ID             bigint not null,
   NAME                 varchar(40),
   primary key (PARTY_ID)
);

create table test_person
(
   PARTY_ID             bigint not null,
   HEIGHT               varchar(8),
   primary key (PARTY_ID),
   constraint FK_Relationship_6 foreign key (PARTY_ID)
      references test_party (PARTY_ID) on delete restrict on update restrict
);

