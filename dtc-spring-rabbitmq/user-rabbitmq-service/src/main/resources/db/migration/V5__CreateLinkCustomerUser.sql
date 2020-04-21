create table IF NOT EXISTS link_customer_user (
  id int not null primary key,
  customer_id integer,
  user_id integer,
  status_date Timestamp,
  comment varchar (255),
  deleted bit,
  deleted_time timestamp,
  deleted_comment varchar (255)
)DEFAULT CHARSET=UTF8;