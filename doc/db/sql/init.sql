drop table book;

drop table book_publisher;

drop table contact;

drop table contractor;

drop table customer;

drop table employee;

drop table family_member;

drop table good;

drop table organization;

drop table party_role_type;

drop table person;

drop table publisher;

drop table service;

drop table student;

drop table teacher;

drop table test_type;

create table book (
book_id              NUMERIC(6)                     not null,
name                 VARCHAR(40),
primary key (book_id)
);

create table publisher (
publisher_id         NUMERIC(6)                     not null,
name                 VARCHAR(40),
primary key (publisher_id)
);

create table book_publisher (
book_id              INTEGER                        not null,
publisher_id         INTEGER                        not null,
published_date       DATE,
primary key (book_id, publisher_id),
foreign key (book_id)
      references book (book_id),
foreign key (publisher_id)
      references publisher (publisher_id)
);

create table organization (
party_id             NUMERIC(6)                     not null,
name                 VARCHAR(40),
tenant_id            INTEGER,
created_at           TIMESTAMP                       default 'CURRENT_TIMESTAMP',
updated_at           TIMESTAMP                       default 'CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP',
lock_version         INTEGER,
updated_by           VARCHAR(40),
created_by           VARCHAR(40),
delete_flag          INTEGER,
deleted_on           TIMESTAMP                       default NULL,
primary key (party_id)
);

create table party_role_type (
role_type_id         INTEGER                        not null,
description          VARCHAR(255),
primary key (role_type_id)
);

create table person (
party_id             NUMERIC(6)                     not null,
name                 VARCHAR(40),
deleted_on           TIMESTAMP                       default NULL,
gender               VARCHAR(1),
birth_date           DATE,
height               VARCHAR(40),
weight               VARCHAR(40),
marital_status       VARCHAR(1),
comments             VARCHAR(255),
tenant_id            INTEGER,
created_at           TIMESTAMP                       default 'CURRENT_TIMESTAMP',
updated_at           TIMESTAMP                       default 'CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP',
lock_version         INTEGER,
updated_by           VARCHAR(40),
created_by           VARCHAR(40),
delete_flag          INTEGER,
primary key (party_id)
);

create table contact (
party_role_id        INTEGER,
from_date            DATE,
due_date             DATE,
party_id             INTEGER                        not null,
role_type_id         INTEGER                        not null,
primary key (party_id, role_type_id),
foreign key (party_id)
      references organization (party_id),
foreign key (role_type_id)
      references party_role_type (role_type_id),
foreign key (party_id)
      references person (party_id)
);

create table contractor (
party_role_id        INTEGER,
from_date            DATE,
due_date             DATE,
party_id             INTEGER                        not null,
role_type_id         INTEGER                        not null,
primary key (party_id, role_type_id),
foreign key (party_id)
      references organization (party_id),
foreign key (role_type_id)
      references party_role_type (role_type_id),
foreign key (party_id)
      references person (party_id)
);

create table customer (
party_role_id        INTEGER,
from_date            DATE,
due_date             DATE,
party_id             INTEGER                        not null,
role_type_id         INTEGER                        not null,
primary key (party_id, role_type_id),
foreign key (party_id)
      references organization (party_id),
foreign key (role_type_id)
      references party_role_type (role_type_id),
foreign key (party_id)
      references person (party_id)
);

create table employee (
party_role_id        INTEGER,
party_id             INTEGER                        not null,
role_type_id         INTEGER                        not null,
from_date            DATE,
due_date             DATE,
primary key (party_id, role_type_id),
foreign key (party_id)
      references organization (party_id),
foreign key (role_type_id)
      references party_role_type (role_type_id),
foreign key (party_id)
      references person (party_id)
);

create table family_member (
party_role_id        INTEGER,
from_date            DATE,
due_date             DATE,
party_id             INTEGER                        not null,
role_type_id         INTEGER                        not null,
primary key (party_id, role_type_id),
foreign key (party_id)
      references organization (party_id),
foreign key (role_type_id)
      references party_role_type (role_type_id),
foreign key (party_id)
      references person (party_id)
);

create table good (
product_id           INTEGER                        not null,
name                 VARCHAR(40),
introduction_date    DATE,
price                FLOAT                           default 0,
primary key (product_id)
);

create table service (
product_id           INTEGER                        not null,
name                 VARCHAR(40),
introduction_date    DATE,
price                FLOAT                           default 0,
primary key (product_id)
);

create table student (
student_id           INTEGER                        not null,
number_of_pages      INTEGER,
primary key (student_id)
);

create table teacher (
teacher_id           INTEGER                        not null,
name                 VARCHAR(40),
primary key (teacher_id)
);

create table test_type (
flg                  SMALLINT,
indicator            VARCHAR(1)
);

