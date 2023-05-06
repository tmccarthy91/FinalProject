DROP TABLE IF EXISTS cat_doctor;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS cats;
DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
owner_pk int NOT NULL AUTO_INCREMENT,
ownerId varchar(40) NOT NULL,
firstName varchar(40) NOT NULL,
lastName varchar(40) NOT NULL,
PRIMARY key (owner_pk),
UNIQUE KEY (ownerId)
);

CREATE TABLE cats (
  cat_pk int unsigned NOT NULL AUTO_INCREMENT,
  owner_pk int,
  catId varchar(40) NOT NULL,
  catName varchar(45) NOT NULL,
  catAge int not null,
  breed varchar(45) NOT NULL,
  color varchar(20) NOT NULL,
  neutered boolean,
  personality varchar(40),
  notes varchar(100),
  PRIMARY KEY (cat_pk),
  unique key (catId),
  foreign key (owner_pk) references owners (owner_pk) on delete CASCADE
);



CREATE TABLE doctors (
doctor_pk int unsigned NOT NULL AUTO_INCREMENT,
doctorId varchar(40) NOT NULL,
firstName varchar(40) NOT NULL,
lastName varchar(40) NOT NULL,
PRIMARY KEY(doctor_pk),
UNIQUE KEY (doctorId)
);

CREATE TABLE cat_doctor (
  cat_fk int unsigned NOT NULL,
  doctor_fk int unsigned NOT NULL,
  FOREIGN KEY (cat_fk) REFERENCES cats (cat_pk) ON DELETE CASCADE,
  FOREIGN KEY (doctor_fk) REFERENCES doctors (doctor_pk) ON DELETE CASCADE
 );