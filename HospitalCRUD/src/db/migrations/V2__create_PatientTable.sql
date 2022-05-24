CREATE TABLE PATIENT(
PATIENTID INT PRIMARY KEY NOT NULL,
FIRST_NAME VARCHAR(30) NOT NULL,
LAST_NAME VARCHAR(30) NOT NULL,
BED_ID INT NOT NULL,
DATE_TIME_BED_VISITED TIMESTAMP NOT NULL,
RADIOLOGY_VISITED BOOLEAN,
FOREIGN KEY (BED_ID) REFERENCES BED(BED_ID)
);

