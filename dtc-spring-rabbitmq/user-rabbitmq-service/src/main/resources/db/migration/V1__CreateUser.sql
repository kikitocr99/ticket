create table IF NOT EXISTS user (
  id int not null primary key,
  name varchar (255),
  description varchar (255),
  role_id int,
  password varchar (60) not null,
  enabled bit,
  first_name varchar (255),
  family_name varchar (255)
)DEFAULT CHARSET=UTF8;

