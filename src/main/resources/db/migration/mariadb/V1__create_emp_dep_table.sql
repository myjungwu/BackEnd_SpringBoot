DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

create table departments (
    id bigint not null auto_increment,
    department_name varchar(255) not null,
    department_description varchar(255),
    primary key (id)
) engine=InnoDB;

create table employees (
    id bigint not null auto_increment,
    email_id varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    department_id bigint,
    primary key (id)
) engine=InnoDB;

alter table IF EXISTS employees add constraint UK_emailid unique (email_id);
alter table IF EXISTS employees add constraint FK_deptid foreign key (department_id) references departments(id);