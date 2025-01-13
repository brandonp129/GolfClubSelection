BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, bags, clubs;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE bags (
    bag_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    bagName varchar(100) NOT NULL,
);

CREATE TABLE clubs (
    club_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    bagName varchar(100) NOT NULL,
    clubDistance INT NOT NULL,
    clubName varchar(100) NOT NULL,
);

COMMIT TRANSACTION;
