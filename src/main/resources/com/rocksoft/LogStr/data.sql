INSERT INTO MYDB.addresses (COUNTRY, CITY, STREET, HOME_NUMBER) VALUES ("BLR", "Minsk", "Leukova", 1),
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
INSERT INTO MYDB.drivers_cars (CAR_MODEL, NUMBER) VALUES ("Mercedes", "0406-7"),
("Volvo", "0203-7"),
("Lada", "0304-7"),
("Peugeot", "0774-7"),
("Peugeot", "0474-7"),
("Volkswagen", "9988-7"),
("Renault", "2223-7");
INSERT INTO MYDB.DRIVERS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Alex", "Ivanoff", "driver", "1992-02-07", 1),
("Sima", "Endelson", "driver", "1969-01-01", 2),
("David", "Sarafyan", "driver", "1988-05-12", 3),
("Ivan", "Ivanoff", "driver", "1981-08-24", 4),
("Alex", "Smirnoff", "driver", "1980-05-30", 6),
("Zurab", "Martinaschvily", "driver", "1988-11-26", 5);
INSERT INTO MYDB.DIRECTORS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Solomon", "Saroumjan", "director", "1990-09-17", 7);
INSERT INTO MYDB.HEADS_OF_DEPARTMENTS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Mikhail", "Zadornov", "head_of_department", "1964-12-10", 8);
INSERT INTO MYDB.LOGISTS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Mikhail", "Saakashvily", "logist", "1978-01-10", 11),
("Dmitry", "Safonoff", "logist", "1992-04-10", 13);
INSERT INTO MYDB.STOREKEEPERS (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES ("Rustam", "Ajbegulin", "storekeeper", "1993-04-01", 9),
("Adolf", "Messer", "storekeeper", "1969-01-01", 10),
("Aram", "Safaryan", "storekeeper", "1988-05-12", 12);
INSERT INTO MYDB.ORDERS (OWNER_ORGANISATION_NAME, OWNERSHIP_TYPE, OPERATION_TYPE, LOGISTS_ID) VALUES ("ASSTRA", "LTD", "TRANSPORTATION", 1);