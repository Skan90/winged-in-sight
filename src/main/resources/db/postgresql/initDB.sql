CREATE TABLE IF NOT EXISTS bird(
  id SERIAL,
  popular_name VARCHAR(30),
  scientific_name VARCHAR(30),
  color VARCHAR(30),
  localization VARCHAR(30),
  photo VARCHAR(500),
  CONSTRAINT bird PRIMARY KEY (id)
);

ALTER SEQUENCE visits_id_seq RESTART WITH 100;