CREATE TABLE POST (
  id           INTEGER IDENTITY PRIMARY KEY,
  title        VARCHAR(256),
  content      VARCHAR(2048),
  reg_date     TIMESTAMP,
  author       VARCHAR(100)
);

CREATE TABLE USER (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30)
);