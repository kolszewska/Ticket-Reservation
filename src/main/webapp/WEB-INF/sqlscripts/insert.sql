DELETE FROM reservation;
DELETE FROM screening;
DELETE FROM movie;

INSERT INTO movie (title,genre) VALUES ('Intouchables','Drama');
INSERT INTO movie (title,genre) VALUES ('Pulp fiction','Drama');
INSERT INTO movie (title,genre) VALUES ('Lion king','For kids');
INSERT INTO movie (title,genre) VALUES ('Monty Python and the Holy Grail','Comedy');

INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 12:30:00',1);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 14:00:00',1);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 16:30:00',1);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 18:30:00',1);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 20:00:00',2);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 23:00:00',2);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 08:00:00',3);
INSERT INTO screening (time,movie_id) VALUES ('2016-11-13 10:00:00',4);
