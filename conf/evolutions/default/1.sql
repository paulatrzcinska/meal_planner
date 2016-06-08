# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                        bigint not null,
  name                      varchar(255),
  calories_per100grams      integer,
  carb_per100grams          integer,
  fat_per100grams           integer,
  protein_per100grams       integer,
  sugar_per100grams         integer,
  constraint pk_product primary key (id))
;

create table product_meal (
  id                        bigint not null,
  user                      varchar(255),
  product                   varchar(255),
  meal_time                 integer,
  meal_weight               integer,
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

create sequence product_seq;

create sequence product_meal_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists product_meal;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists product_meal_seq;

drop sequence if exists user_seq;

