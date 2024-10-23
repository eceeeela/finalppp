PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE contacts(name text, id integer, schedule text, salary integer);
INSERT INTO contacts VALUES('manager',78,'Mon - Fri: 8-5',27);
INSERT INTO contacts VALUES('owner',11,'Mon & Wed: 3-5',54);
COMMIT;
