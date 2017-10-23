
-- Opprett et skjema med navn "ratemate" i databasen--
-- Forelesere, studenter og fag må legges manuelt inn i databasen -- 

CREATE TABLE IF NOT EXISTS ratemate.fag (
emnekode 		VARCHAR(15) NOT NULL,
navn 			VARCHAR(30),
PRIMARY KEY(emnekode));

CREATE TABLE IF NOT EXISTS ratemate.foreleser (
ansattnr 		VARCHAR(6)	NOT NULL,
navn 			VARCHAR(40),
passord			VARCHAR(50) NOT NULL,
fagliste		VARCHAR(15),
PRIMARY KEY(ansattnr),
FOREIGN KEY (fagliste) REFERENCES (ratemate.fag(emnekode));

CREATE TABLE IF NOT EXISTS ratemate.student (
studentnr 		VARCHAR(6) NOT NULL,
navn			VARCHAR(40),
fagliste		VARCHAR(15),
rating			INTEGER, check rating >= 0 and rating <= 2,
PRIMARY KEY (studentnr),
FOREIGN KEY (ratemate.fag(emnekode));

CREATE TABLE IF NOT EXISTS ratemate.forelesning (
id 			INTEGER NOT NULL,
dato		VARCHAR(10),
kl_start	VARCHAR(10),
kl_slutt	VARCHAR(10),
fag			VARCHAR(15),
foreleser	VARCHAR(6),
bra			INTEGER,
middels 	INTEGER,
daarlig		INTEGER,
PRIMARY KEY(id),
FOREIGN KEY (fag) REFERENCES (ratemate.fag(emnekode),
FOREIGN KEY (foreleser) REFERENCES (ratemate.foreleser(ansattnr));

