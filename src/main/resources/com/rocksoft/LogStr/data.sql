USE mydb;
INSERT INTO addresses (COUNTRY, CITY, STREET, HOME_NUMBER) VALUES ("BLR", "Minsk", "Leukova", 1),
("BLR", "Minsk", "Leukova", 3),
("BLR", "Minsk", "Mohileuskaya", 1),
("BLR", "Minsk", "Mohileuskaya", 2),
("BLR", "Minsk", "Mohileuskaya", 4),
("BLR", "Minsk", "Berouta", 2),
("BLR", "Minsk", "Joukova", 8),
("BLR", "Minsk", "Joukova", 17),
("BLR", "Minsk", "Pushkinskaya", 53),
("BLR", "Minsk", "Spartiunaya", 48),
("BLR", "Minsk", "Tolbuhina", 94),
("BLR", "Minsk", "Voronyanskogo", 14),
("BLR", "Minsk", "Schkalova", 47),
("BLR", "Minsk", "Aerodromnaja", 38),
("BLR", "Minsk", "Dzerjinskogo", 126),
("BLR", "Minsk", "Dzerjinskogo", 21),
("BLR", "Minsk", "Asanalieva", 31);
INSERT INTO drivers_cars (CAR_MODEL, NUMBER) VALUES ("Mercedes", "0406-7"),
("Volvo", "0203-7"),
("Lada", "0304-7"),
("Peugeot", "0774-7"),
("Peugeot", "0474-7"),
("Volkswagen", "9988-7"),
("Renault", "2223-7");
INSERT INTO DRIVERS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Alex", "Ivanoff", "driver", "1992-02-07", 1),
("Sima", "Endelson", "driver", "1969-01-01", 2),
("David", "Sarafyan", "driver", "1988-05-12", 3),
("Ivan", "Ivanoff", "driver", "1981-08-24", 4),
("Alex", "Smirnoff", "driver", "1980-05-30", 6),
("Zurab", "Martinaschvily", "driver", "1988-11-26", 5);
INSERT INTO DIRECTORS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Solomon", "Saroumjan", "director", "1990-09-17", 7);
INSERT INTO HEADS_OF_DEPARTMENTS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Mikhail", "Zadornov", "head_of_department", "1964-12-10", 8);
INSERT INTO LOGISTS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Mikhail", "Saakashvily", "logist", "1978-01-10", 11),
("Dmitry", "Safonoff", "logist", "1992-04-10", 13);
INSERT INTO STOREKEEPERS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Rustam", "Ajbegulin", "storekeeper", "1993-04-01", 9),
("Adolf", "Messer", "storekeeper", "1969-01-01", 10),
("Aram", "Safaryan", "storekeeper", "1988-05-12", 12);
INSERT INTO ORDERS (OWNER_ORGANISATION_NAME, OWNERSHIP_TYPE, OPERATION_TYPE, LOGISTS_ID) VALUES ("ASSTRA", "LTD", "TRANSPORTATION", 1);
ALTER TABLE drivers_cars COMMENT = 'alter table operations';
ALTER TABLE drivers_cars ADD CAR_AGE INT NOT NULL;
ALTER TABLE drivers_cars MODIFY CAR_AGE TINYINT NOT NULL DEFAULT '0';
INSERT INTO drivers_cars (CAR_MODEL, NUMBER, CAR_AGE) VALUES ("Alfa Romeo", "0132-7", 1),
("Alfa Romeo", "0332-7", 2),
("Audi", "2233-7", 2),
("BMW", "6677-7", 2),
("Lada", "1744-7", 2),
("Alfa Romeo", "9090-7", 4);
UPDATE drivers_cars SET CAR_MODEL='BMW' WHERE ID=3;
SELECT * FROM drivers_cars;
SELECT ID, CAR_MODEL, CREATED_AT, CAR_AGE FROM drivers_cars WHERE (CAR_AGE < 1 && CAR_MODEL <> "BMW") || (CAR_MODEL='Lada' && CAR_AGE > 1);
SELECT ID, CAR_MODEL, CAR_AGE, CREATED_AT FROM drivers_cars ORDER BY CAR_MODEL DESC LIMIT 5;
DELETE FROM drivers_cars WHERE ID=3;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM drivers_cars WHERE CAR_AGE=4;
SET SQL_SAFE_UPDATES = 1;
ALTER TABLE drivers_cars DROP COLUMN CAR_AGE;
INSERT INTO driver_has_drivers_cars (DRIVER_ID, DRIVERS_CARS_ID) VALUES (2, 6), (1, 7),
(2, 4),
(2, 5),
(1, 5),
(1, 6),
(3, 2),
(4, 4),
(5, 5);
SELECT * FROM driver_has_drivers_cars;



