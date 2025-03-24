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



-- checking 

show tables;

describe artwork;

-- inserting data (records)

-- 1. artist table

insert into artist (name, biography, birth_date, nationality, website, contact_info) values
('Leonardo da Vinci', 'Renaissance artist known for Mona Lisa', '1452-04-15', 'Italian', 'https://leonardo.com', 'leonardo@example.com'),
('Vincent van Gogh', 'Dutch Post-Impressionist painter', '1853-03-30', 'Dutch', 'https://vangogh.com', 'vangogh@example.com'),
('Pablo Picasso', 'Spanish painter and sculptor', '1881-10-25', 'Spanish', 'https://picasso.com', 'picasso@example.com'),
('Claude Monet', 'French Impressionist painter', '1840-11-14', 'French', 'https://monet.com', 'monet@example.com'),
('Frida Kahlo', 'Mexican painter known for self-portraits', '1907-07-06', 'Mexican', 'https://kahlo.com', 'kahlo@example.com');

select * from artist;

-- 2. artwork table

insert into artwork (title, description, creation_date, medium, image_url, artist_id) values
('Mona Lisa', 'A portrait of Lisa Gherardini', '1503-01-01', 'Oil on wood', 'https://example.com/mona_lisa.jpg', 1),
('Starry Night', 'A famous night sky painting', '1889-06-01', 'Oil on canvas', 'https://example.com/starry_night.jpg', 2),
('Guernica', 'Anti-war painting during Spanish Civil War', '1937-05-01', 'Oil on canvas', 'https://example.com/guernica.jpg', 3),
('Water Lilies', 'Series of paintings depicting a pond', '1915-01-01', 'Oil on canvas', 'https://example.com/water_lilies.jpg', 4),
('The Two Fridas', 'Self-portrait of Frida Kahlo', '1939-01-01', 'Oil on canvas', 'https://example.com/two_fridas.jpg', 5);

select * from artwork;

-- 3. gallery table

insert into gallery (name, description, location, curator_id, opening_hours) values
('Louvre Museum', 'Historic museum in Paris', 'Paris, France', 1, '9 AM - 6 PM'),
('Van Gogh Museum', 'Museum dedicated to Van Gogh', 'Amsterdam, Netherlands', 2, '10 AM - 5 PM'),
('Museo Picasso', 'Museum featuring Picasso works', 'Barcelona, Spain', 3, '10 AM - 7 PM'),
('Musée de l\'Orangerie', 'Famous for Monet’s paintings', 'Paris, France', 4, '9 AM - 5 PM'),
('Frida Kahlo Museum', 'Museum about Frida Kahlo', 'Mexico City, Mexico', 5, '10 AM - 6 PM');

select * from gallery;

-- 4. artwork_gallery table

insert into artwork_gallery (artwork_id, gallery_id) values
(1, 1), -- Mona Lisa's Louvre Museum
(2, 2), -- Starry Night's Van Gogh Museum
(3, 3), -- Guernica's Museo Picasso
(4, 4), -- Water Lilies's Musée de l'Orangerie
(5, 5); -- The Two Fridas's Frida Kahlo Museum

select * from artwork_gallery;

-- 5. user table

insert into user (username, password, email, first_name, last_name, date_of_birth, profile_picture) values
('artlover123', 'password123', 'artlover@example.com', 'Alice', 'Smith', '1990-05-10', 'https://example.com/alice.jpg'),
('vangoghfan', 'vangoghrocks', 'vgfan@example.com', 'Bob', 'Johnson', '1985-08-15', 'https://example.com/bob.jpg'),
('picassomaster', 'cubism4life', 'picasso_fan@example.com', 'Charlie', 'Davis', '1992-12-01', 'https://example.com/charlie.jpg'),
('monetfanatic', 'waterlilies', 'monet_fan@example.com', 'David', 'Brown', '1988-03-25', 'https://example.com/david.jpg'),
('fridakfan', 'mexicanart', 'frida_fan@example.com', 'Eve', 'Martinez', '1995-07-20', 'https://example.com/eve.jpg');

select * from user;

-- 6. favorite_artwork table

insert into favorite_artwork (user_id, artwork_id) values
(1, 1), -- Alice likes Mona Lisa
(1, 2), -- Alice likes Starry Night
(2, 2), -- Bob likes Starry Night
(3, 3), -- Charlie likes Guernica
(4, 4); -- David likes Water Lilies

select * from favorite_artwork;

