CREATE TABLE USERCREDS (
	USER_NAME varchar(255),
	PASS_WORD VARCHAR(255)
)

SELECT * from USERCREDS;

INSERT INTO USERCREDS VALUES('Jegadeesh','abcd@1234');

--Search particular record

SELECT * from USERCREDS
Where USER_NAME='Jegadeesh'


--Delete Table
DROP TABLE USERCREDS;

CREATE TABLE USERCREDS (
	username varchar(255),
	pass VARCHAR(255)
)

-- Insert Values
INSERT INTO USERCREDS VALUES('Jegadeesh','abcd@1234');

SELECT * from USERCREDS;

--Insert Multiple Values
INSERT INTO USERCREDS
VALUES
	('PiratePanda1','password123'),
	('Ackermann1','taoisT@123s'),
	('Agent J1','MFFagent@J');

SELECT * from USERCREDS;

--GET PARTICULAR RECORDS
SELECT username FROM USERCREDS
WHERE username='Ackermann';