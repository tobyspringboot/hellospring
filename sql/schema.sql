create table orders (id bigint not null, no varchar(255), total numeric(38,2), primary key (id));
alter table if exists orders drop constraint if exists UK_43egxxciqr9ncgmxbdx2avi8n;
alter table if exists orders add constraint UK_43egxxciqr9ncgmxbdx2avi8n unique (no);
create sequence orders_SEQ start with 1 increment by 50;