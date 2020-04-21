create table IF NOT EXISTS  role (
  id int not null primary key,
  name varchar (255),
  description varchar (255),
  deleted bit,
  deleted_time timestamp,
  deleted_comment varchar (255)
)DEFAULT CHARSET=UTF8;
