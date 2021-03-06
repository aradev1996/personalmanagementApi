DROP TABLE IF EXISTS URLAUB;
DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (
  ID              CHAR(36)        not null,
  FIRST_NAME VARCHAR(250) ,
  LAST_NAME VARCHAR(250) ,
  ADRESS VARCHAR(250) ,
  BIRTH_DATE DATE,
  SALARY NUMBER(19),
  RECORDING_DATE DATE ,
  LEAVING_DATE DATE,
  STATUS     NUMBER(1),
  HOLIDAY_DAYS NUMBER(19),

  primary key (ID)
);

INSERT INTO PERSON(ID,FIRST_NAME,LAST_NAME, ADRESS, BIRTH_DATE, SALARY, RECORDING_DATE, LEAVING_DATE, STATUS, HOLIDAY_DAYS)
VALUES ('81711e77-5b7a-4b48-adcc-700f5e9ab156', 'TESTNAME', 'Huber', 'TESTADRESS', '2008-11-11', 1010, '2008-11-11', '2008-11-11', 1, 25);

INSERT INTO PERSON(ID,FIRST_NAME,LAST_NAME, ADRESS, BIRTH_DATE, SALARY, RECORDING_DATE, LEAVING_DATE, STATUS, HOLIDAY_DAYS)
VALUES ('81711e77-5b7a-4b48-adcc-720f5e9ab156', 'TESTNAME', 'Mustermann', 'TESTADRESS', '2008-11-11', 1300, '2008-11-11', '2008-11-11', 1, 54);

INSERT INTO PERSON(ID,FIRST_NAME,LAST_NAME, ADRESS, BIRTH_DATE, SALARY, RECORDING_DATE, LEAVING_DATE, STATUS, HOLIDAY_DAYS)
VALUES ('81711e77-5b7a-4b48-adcc-710f5e9ab156', 'TESTNAME', 'Mueller', 'TESTADRESS', '2008-11-11', 1000, '2008-11-11', '2008-11-11', 1, 15);

CREATE TABLE URLAUB (
  ID  CHAR(36) not null,
  START_DATE DATE,
  END_DATE   DATE,
  PERSON_ID  CHAR(36),
  primary key (ID),
  constraint FK_DAFVS0EZ798YCK39HFRY
        foreign key (PERSON_ID) references PERSON
)
