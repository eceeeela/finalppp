PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE inventory(product text, quantity integer);
INSERT INTO inventory VALUES('coke',50);
INSERT INTO inventory VALUES('sprite',50);
INSERT INTO inventory VALUES('pizza',50);
INSERT INTO inventory VALUES('ice cream',50);
INSERT INTO inventory VALUES('cake',50);
COMMIT;
