
-- Opprett et skjema med navn "ratemate" i databasen--
-- Forelesere, studenter og fag må legges manuelt inn i databasen -- 

CREATE TABLE IF NOT EXISTS ratemate.fag (
emnekode 		VARCHAR(15) NOT NULL,
navn 			VARCHAR(30),
PRIMARY KEY(emnekode));

CREATE TABLE IF NOT EXISTS ratemate.foreleser (
ansattnr 		VARCHAR(6)	NOT NULL,
navn 			VARCHAR(40),
fagliste		VARCHAR(15),
PRIMARY KEY(id),
FOREIGN KEY (fagliste) REFERENCES (ratemate.fag(emnekode));

CREATE TABLE IF NOT EXISTS ratemate.student (
studentnr 		VARCHAR(6) NOT NULL,
navn			VARCHAR(40),
fagliste		VARCHAR(15),
rating			INTEGER, check rating >= 0 and rating <= 2,
PRIMARY KEY (studentnr),
FOREIGN KEY (ratemate.fag(emnekode));



