DROP TABLE reservation;
DROP TABLE screening;
DROP TABLE movie;

CREATE TABLE movie (
	id SERIAL PRIMARY KEY,
  title VARCHAR NOT NULL,
	genre VARCHAR NOT NULL
);

CREATE TABLE screening (
  id SERIAL PRIMARY KEY,
  time TIMESTAMP NOT NULL,
  auditorium_id int NOT NULL DEFAULT 1,
  movie_id int NOT NULL REFERENCES movie
);

CREATE TABLE reservation (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  telephone VARCHAR NOT NULL,
  number_of_tickets INT NOT NULL,
  confirmed BOOLEAN NOT NULL,
  verification_key VARCHAR NOT NULL,
  screening_id int REFERENCES screening
);