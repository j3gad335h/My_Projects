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

-- lets Alter column table and set user name unique
ALTER TABLE USERCREDS
ADD UNIQUE (username);
