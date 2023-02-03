drop database if exists club_travel;
create database club_travel;
use club_travel;

create table traveler(
    id_traveler bigint primary key auto_increment,
    image_link varchar(500),
    image mediumblob,
    contact bigint,
    user bigint
);

create table contact(
    id_contact bigint primary key auto_increment,
    name varchar(150) not null,
    phone varchar(13) not null,
    email varchar(150) unique not null
);

create table destinations(
    id_destinations bigint primary key auto_increment,
    reference varchar(100),
    image_link varchar(500),
    image mediumblob,
    city bigint
);

create table country(
    id_country bigint primary key auto_increment,
    portuguese_name varchar(100) not null,
    english_name varchar(100) not null,
    image_link varchar(500),
    image mediumblob
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

create table region(
    id_region bigint primary key auto_increment,
    name varchar(100) not null,
    uf varchar(2) not null
);

create table state(
    id_state bigint primary key auto_increment,
    uf_code bigint unique,
    name varchar(100) not null,
    uf varchar(2) not null,
    region bigint,
    country bigint
);

create table city(
    id_city bigint primary key auto_increment,
    ibge_code varchar(7) not null,
    name varchar(100) not null,
    state bigint
);

create table news(
    id_news bigint primary key auto_increment,
    title varchar(500) not null,
    text varchar(500) not null,
    date_time datetime not null,
    image_link varchar(500),
    image mediumblob    
);

create table sub_news(
    id_sub_news bigint primary key auto_increment,
    sub_title varchar(500),
    text varchar(500) not null,
    image_link varchar(500),
    image mediumblob,
    news bigint
);

create table destination_news(
    id_destination_news bigint primary key auto_increment,
    news bigint,
    destination bigint
);

create table comments (
    id_comments bigint primary key auto_increment,
    text varchar(250) not null,
    date_time datetime not null,
    traveler bigint,
    news bigint
);

create table events (
    id_events bigint primary key auto_increment,
    start_date date not null,
    end_date date not null,
    description varchar(300) not null,
    destinations bigint
);

create table users(
    id_user bigint primary key auto_increment,
    user_name varchar(255) unique not null,
    password varchar(255) not null
);

create table permission(
    id_permission bigint primary key auto_increment,
    description varchar(100)
);

create table user_permission(
    id_user bigint,
    id_permission bigint,
    primary key ( id_user, id_permission)
);

alter table destinations add constraint fk_city_destinations foreign key (city) references city (id_city);
alter table sub_news add constraint fk_news_sub_news foreign key (news) references news (id_news);
alter table destination_news add constraint fk_destination_news_news foreign key (news) references news (id_news);
alter table destination_news add constraint fk_destination_news_destinations foreign key (destination) references destinations (id_destinations);
alter table comments add constraint fk_traveler_comments foreign key (traveler) references traveler (id_traveler);
alter table comments add constraint fk_news_comments foreign key (news) references news (id_news);
alter table events add constraint fk_destinations_events foreign key (destinations) references destinations (id_destinations);
alter table state add constraint fk_country_state foreign key (country) references country (id_country);
alter table state add constraint fk_region_state foreign key (region) references region (id_region);
alter table city add constraint fk_state_city foreign key (state) references state (uf_code);

alter table user_permission add constraint fk_user_permission_user foreign key (id_user) references users (id_user);
alter table user_permission add constraint fk_user_permission_permission foreign key (id_permission) references permission (id_permission);
alter table traveler add constraint fk_contact_traveler foreign key (contact) references contact (id_contact);
alter table traveler add constraint fk_traveler_users foreign key (user) references users (id_user);

insert into permission (description) values ("administrator"), ("traveler");
insert into users (user_name, password) values ("king", "123456");
insert into user_permission (id_user, id_permission) values (1, 1);
insert into user_permission (id_user, id_permission) values (1, 2);
insert into contact (name, phone, email) values ("web3travelclub", "4002-8922", "web3travelclub.@email.com");
insert into traveler (contact, user) values (1, 1);
