# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table meal_time (
  id                        bigint not null,
  meal_time_name            varchar(255),
  constraint pk_meal_time primary key (id))
;

create table product (
  id                        bigint not null,
  name                      varchar(255),
  calories_per100grams      integer,
  carb_per100grams          integer,
  fat_per100grams           integer,
  protein_per100grams       integer,
  sugar_per100grams         integer,
  product_meal_id           bigint,
  constraint pk_product primary key (id))
;

create table product_meal (
  id                        bigint not null,
  user_id                   integer,
  meal_time_id              bigint,
  meal_weight               integer,
  mealtime_id               varchar(255),
  date                      varchar(255),
  constraint pk_product_meal primary key (id))
;

create table user (
  id                        integer not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  surname                   varchar(255),
  gender                    boolean,
  weight                    integer,
  height                    integer,
  age                       integer,
  constraint pk_user primary key (id))
;

create sequence meal_time_seq;

create sequence product_seq;

create sequence product_meal_seq;

create sequence user_seq;

alter table product add constraint fk_product_productMeal_1 foreign key (product_meal_id) references product_meal (id) on delete restrict on update restrict;
create index ix_product_productMeal_1 on product (product_meal_id);
alter table product_meal add constraint fk_product_meal_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_product_meal_user_2 on product_meal (user_id);
alter table product_meal add constraint fk_product_meal_mealTime_3 foreign key (meal_time_id) references meal_time (id) on delete restrict on update restrict;
create index ix_product_meal_mealTime_3 on product_meal (meal_time_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists meal_time;

drop table if exists product;

drop table if exists product_meal;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists meal_time_seq;

drop sequence if exists product_seq;

drop sequence if exists product_meal_seq;

drop sequence if exists user_seq;

