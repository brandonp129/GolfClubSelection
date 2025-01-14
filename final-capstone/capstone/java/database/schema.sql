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
    bag_name VARCHAR(100) NOT NULL,
    CONSTRAINT FK_bag_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE clubs (
    club_id SERIAL PRIMARY KEY,
    bag_id INT NOT NULL,
    club_name VARCHAR(100) NOT NULL,
    club_distance INT, -- Average distance in yards
    club_type VARCHAR(50), -- e.g., Driver, Iron, Putter
    CONSTRAINT FK_club_bag FOREIGN KEY (bag_id) REFERENCES bags(bag_id) ON DELETE CASCADE
);

CREATE TABLE club_types (
    club_type_id SERIAL PRIMARY KEY,
    club_type_name VARCHAR(50) NOT NULL UNIQUE, -- e.g., Driver, Iron, Putter
    description TEXT
);

CREATE TABLE user_preferences (
    preference_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    handicap DECIMAL(4, 1), -- e.g., 12.3
    favorite_brand VARCHAR(50),
    CONSTRAINT FK_preference_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE rounds (
    round_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    date_played DATE NOT NULL,
    course_name VARCHAR(100),
    total_score INT,
    notes TEXT,
    CONSTRAINT FK_round_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL UNIQUE,
    location VARCHAR(100),
    par INT -- Total par of the course
);

CREATE TABLE bag_clubs (
    bag_id INT NOT NULL,
    club_id INT NOT NULL,
    PRIMARY KEY (bag_id, club_id),
    CONSTRAINT FK_bag_club_bag FOREIGN KEY (bag_id) REFERENCES bags(bag_id) ON DELETE CASCADE,
    CONSTRAINT FK_bag_club_club FOREIGN KEY (club_id) REFERENCES clubs(club_id) ON DELETE CASCADE
);

CREATE TABLE user_bags (
    user_id INT NOT NULL,
    bag_id INT NOT NULL,
    PRIMARY KEY (user_id, bag_id),
    CONSTRAINT FK_user_bags_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_user_bags_bag FOREIGN KEY (bag_id) REFERENCES bags(bag_id) ON DELETE CASCADE
);

CREATE TABLE user_clubs (
    user_id INT NOT NULL,
    club_id INT NOT NULL,
    PRIMARY KEY (user_id, club_id),
    CONSTRAINT FK_user_clubs_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_user_clubs_club FOREIGN KEY (club_id) REFERENCES clubs(club_id) ON DELETE CASCADE
);

CREATE TABLE user_courses (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    date_played DATE NOT NULL,
    score INT,
    notes TEXT,
    PRIMARY KEY (user_id, course_id, date_played),
    CONSTRAINT FK_user_courses_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_user_courses_course FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE round_players (
    round_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (round_id, user_id),
    CONSTRAINT FK_round_players_round FOREIGN KEY (round_id) REFERENCES rounds(round_id) ON DELETE CASCADE,
    CONSTRAINT FK_round_players_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);


COMMIT TRANSACTION;
