drop database if exists club_travel;
create database club_travel;
use club_travel;

create table traveler(
    id_traveler bigint primary key auto_increment,
    name varchar(150) not null,
    phone varchar(13) not null,
    email varchar(150) unique not null,
    image_link varchar(500),
    image mediumblob
);

create table destinations(
    id_destinations bigint primary key auto_increment,
    country varchar(100) not null,
    state varchar(100) not null,
    city varchar(100) not null,
    image_link varchar(500),
    image mediumblob
);

create table news(
    id_news bigint primary key auto_increment,
    title varchar(500) not null,
    text varchar(500) not null,
    subtitle varchar(100),
    date_time datetime not null,
    image_link varchar(500),
    image mediumblob,
    destinations bigint,
    traveler bigint
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

alter table news add constraint fk_traveler_news foreign key (traveler) references traveler (id_traveler);
alter table news add constraint fk_destinations_news foreign key (destinations) references destinations (id_destinations);
alter table comments add constraint fk_traveler_comments foreign key (traveler) references traveler (id_traveler);
alter table comments add constraint fk_news_comments foreign key (news) references news (id_news);
alter table events add constraint fk_destinations_events foreign key (destinations) references destinations (id_destinations);

insert into traveler (name, phone, email) values ("Club Travle", "4002-8922", "ehFunkDoJapones.@QueVaiDarPS2.com");
