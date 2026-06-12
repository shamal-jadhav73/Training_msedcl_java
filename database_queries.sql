create database hibernate_db;
use hibernate_db;
create table employee_details
(
  employee_id INT auto_increment PRIMARY KEY,
  name varchar(50) NOT NULL,
  salary double NOT NULL
  );
  
  
  INSERT INTO EMPLOYEE_DETAILS(NAME,SALARY) VALUES('Abhay',150000);
   INSERT INTO EMPLOYEE_DETAILS(NAME,SALARY) VALUES('Veerti',150000);
   INSERT INTO EMPLOYEE_DETAILS(NAME,SALARY) VALUES('Poonam',150000);
   
   
SELECT * FROM EMPLOYEE_DETAILS;

SELECT * FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID=2;


create table login_details
(
 login_id INT PRIMARY KEY,
 password varchar(20),
 invalid_login_count int,
 max int,
 status varchar(50)
 );
 
 insert into login_details values(101,"xyz@123",0,1,"active");
 insert into login_details values(102,"abc@123",2,2,"active");
 insert into login_details values(103,"abc@123",2,3,"blockedlogin_details");
 
 update login_details set status="blocked" where login_id=103;
 
 select * from login_details;
 
 create table address_details
 (
   address_id int auto_increment primary key,
   city varchar(50) not null,
   pin_code varchar(10) not null
);

create table user_details
(
  user_id int auto_increment primary key,
  name varchar(50) not null,
  address_id int,
  constraint address_id_fk foreign key(address_id) references address_details(address_id)
);



insert into address_details(city,pin_code) values('Mumbai','400012');
insert into address_details(city,pin_code) values('Thane','421352');
insert into address_details(city,pin_code) values('Dhule','424002');

insert into user_details(name,address_id) values('Seema',1);

insert into user_details(name,address_id) values('Meena',2);

select * from address_details;
select * from user_details;

Drop table employee_details;

create table employee_details
( 
   employee_id INT auto_increment primary KEY,
   NAME VARCHAR(50),
   SALARY double,
   DEPARTMENT_id INT,
   CONSTRAINT DEPARTMENT_id_fk foreign key(DEPARTMENT_id) references DEPARTMENT_details(DEPARTMENT_id)
);

CREATE TABLE DEPARTMENT_DETAILS
(
 DEPARTMENT_id INT auto_increment primary KEY,
 DEPARTMENT_NAME VARCHAR(80)
 );
 
 
 INSERT INTO DEPARTMENT_DETAILS(DEPARTMENT_NAME) VALUES ('IT');
  INSERT INTO DEPARTMENT_DETAILS(DEPARTMENT_NAME) VALUES ('HR');
   INSERT INTO DEPARTMENT_DETAILS(DEPARTMENT_NAME) VALUES ('TECHNICAL');
   
   
   INSERT INTO employee_details(NAME,SALARY,DEPARTMENT_ID) VALUES ('RAHUL',150000.0,1);
   INSERT INTO employee_details(NAME,SALARY,DEPARTMENT_ID) VALUES ('VIRAT',160000.0,1);
   INSERT INTO employee_details(NAME,SALARY,DEPARTMENT_ID) VALUES ('Shailesh',190000.0,1);
   
   update employee_details set department_id=3
   where employee_id=3;
   select * from employee_details;
    select * from department_details;
    
    
    create table product_details
    (
    product_id int auto_increment primary key,
    name varchar(100),
    price double
    );
    
    insert into product_details(name,price) values('School Bag',800.00);
    insert into product_details(name,price) values('Bottle',100.00);
    insert into product_details(name,price) values('Tiffin',300.00);
    
    select * from product_details;
    
    
    CREATE TABLE MEMBER_DETAILS
    (
      member_code int auto_increment primary key,
      member_name varchar(60),
      member_type varchar(60),
	  issue_count int
      );
      
      create table member_type
        (
		member_type_id int auto_increment primary key,
        member_type varchar(60),
        max_allowed_count int
        );
        
        create table book_details
        (
          book_code int auto_increment primary key,
          book_title varchar(60),
          book_author varchar(60),
          issuable_status varchar(60),
          availability_status boolean
		);
          
         create table Issue_details
         (
           Issue_id int auto_increment primary key,
           book_code int ,
           member_code int,
           issue_date date,
           Due_date date,
           CONSTRAINT member_code_fk foreign key(member_code) references member_details(member_code),
           CONSTRAINT book_code_fk foreign key(book_code) references book_details(book_code)
         );
         
         
         select * from member_details;
         select * from book_details;
         select * from member_type;
         truncate table member_type;
         insert into  member_type(member_type,max_allowed_count) values('Teacher',25);
         
         
         create database customer_db;
         
         use customer_db;
         
         create table customer_details
         (
           customer_id int primary key auto_increment,
           name varchar(50) not null,
           email varchar(50) not null,
           mobile_number varchar(15) not null
           );
           
           
           insert into customer_details(name,email,mobile_number) values ('Reema','reema@gmail.com','1234567890');
            insert into customer_details(name,email,mobile_number) values ('Seema','seema@gmail.com','0987654321');
            
            select * from customer_details;
            
            delete from customer_details where customer_id in (2,4);
            
            alter table customer_details add column(created_by varchar(15),
													created_at datetime,
													updated_by varchar(15),
                                                     updated_at datetime);
                                                     
                                                     
                                                     
                                                     
	create database accounts_db;
         drop database accouts_db;
	use accounts_db;
    
    create table account_details
    (
     account_id int primary key auto_increment,
     customer_id int not null,
     account_type varchar(50) not null,
     balance double
     );
     
     alter table account_details modify column balance double default 0;
     
      alter table account_details add column(created_by varchar(15),
													created_at datetime,
													updated_by varchar(15),
                                                     updated_at datetime);
     
  
 select * from account_details;
 
 truncate table account_details;
  
  commit;
  create database transactions_db;
  
  use transactions_db;
    
    
    create table transactions_details
    (
       transaction_id int auto_increment primary key,
       account_id int not null,
       transaction_type varchar(50) not null,
       amount double,
       transaction_date datetime
       );
       
        alter table transactions_details add column(created_by varchar(15),
													created_at datetime,
													updated_by varchar(15),
                                                     updated_at datetime);
                                                     
                                                     select * from transactions_details;
	
    create database user_db;
    use user_db;
    
    create table user_details
    (
      user_id int primary key auto_increment,
      user_name varchar(50),
      password varchar(50),
      role varchar(50)
    );
    
    
    insert into user_details(user_name,password,role) values('Seema','Seema@123','ADMIN');
    insert into user_details(user_name,password,role) values('Reema','Reema@123','USER');
    
    SELECT * FROM USER_DETAILS;