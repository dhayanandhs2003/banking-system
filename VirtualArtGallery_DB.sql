-- CASE STUDY SQL PART

CREATE DATABASE VirtualArtGallery;

USE VirtualArtGallery;

-- art table creation 

create table artwork (
    artwork_id int primary key auto_increment,
    title varchar(255) not null,
    artist_id int,
    description text,
    creation_date date,
    medium varchar(100),
    image_url varchar(255),
    foreign key (artist_id) references artist(artist_id) on delete cascade
);

-- artist table creation

create table artist (
    artist_id int primary key auto_increment,
    name varchar(255) not null,
    biography text,
    birth_date date,
    nationality varchar(100),
    website varchar(255),
    contact_info varchar(255)
);

