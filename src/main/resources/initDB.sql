DROP TABLE IF EXISTS bird CASCADE;
CREATE TABLE IF NOT EXISTS bird(
  id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  name_pt_br VARCHAR(100),
  name_eng VARCHAR(100),
  species VARCHAR(100) NOT NULL,
  family VARCHAR(100),
  size INTEGER,
  gender VARCHAR(100),
  color VARCHAR(100),
  habitat VARCHAR(100),
  photo VARCHAR(500),
  localization VARCHAR(240),
  CONSTRAINT production UNIQUE(species)
);
