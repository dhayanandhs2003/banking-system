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

-- creating user table
-- i have not added the favorite_artworks column inside the user table because of 1NF Each column should contain atomic (indivisible) values
-- and it is difficult to write qurries so i have made a junction table

create table user (
    user_id int primary key auto_increment,
    username varchar(50) not null unique,
    password varchar(255) not null,
    email varchar(255) not null unique,
    first_name varchar(100),
    last_name varchar(100),
    date_of_birth date,
    profile_picture varchar(255)
);

-- creating gallery table

create table gallery (
    gallery_id int primary key auto_increment,
    name varchar(255) not null,
    description text,
    location varchar(255),
    curator_id int, -- reference for artist id
    opening_hours varchar(255),
    foreign key (curator_id) references artist(artist_id) on delete set null
);

-- creating favorite_artwork table mentioned in the user favorite artwork part many to many

create table favorite_artwork (
    user_id int,
    artwork_id int,
    primary key (user_id, artwork_id),
    foreign key (user_id) references user(user_id) on delete cascade,
    foreign key (artwork_id) references artwork(artwork_id) on delete cascade
);

-- creating artwork_gallery table mentioned in the many to many section

create table artwork_gallery (
    artwork_id int,
    gallery_id int,
    primary key (artwork_id, gallery_id),
    foreign key (artwork_id) references artwork(artwork_id) on delete cascade,
    foreign key (gallery_id) references gallery(gallery_id) on delete cascade
);

