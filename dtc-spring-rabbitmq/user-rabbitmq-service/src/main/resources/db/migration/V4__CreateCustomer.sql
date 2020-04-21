create table IF NOT EXISTS customer (
  id int not null primary key,
  name varchar (255),
  pione_id varchar (255),
  khk_id varchar (255),
  pay_interval integer,
  credit_limit integer,
  reached_credit_limit integer,
  last_pay_day Timestamp,
  identify_number varchar (255),
  iln varchar (255),
  parent_id integer,
  insert_time Timestamp,
  taxNumber varchar (255),
  tax_office_id integer,
  cost_unit_iln varchar (255)
)DEFAULT CHARSET=UTF8;
