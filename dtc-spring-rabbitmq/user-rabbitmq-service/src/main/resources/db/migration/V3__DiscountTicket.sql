create table IF NOT EXISTS  discount_ticket_condition (
  id int not null primary key,
  name varchar (255),
  description varchar (255),
  condition_start Timestamp,
  condition_end Timestamp,
  owner_id integer,
  insert_time Timestamp,
  deleted bit,
  deleted_time timestamp,
  deleted_comment varchar (255)
)DEFAULT CHARSET=UTF8;



