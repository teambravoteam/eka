-- 학생유저(eka페이지유저)

CREATE TABLE EkaUser(
	eid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(20) 	NOT NULL,
	userPw			VARCHAR(20) 	NOT NULL,
	name			VARCHAR(20) 	NOT NULL,
	gender			VARCHAR(20) 	NOT NULL,
	ssn				VARCHAR(20) 	NOT NULL,
	phone			VARCHAR(20) 	NOT NULL,
	email			VARCHAR(20) 	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
);


SELECT * FROM Student;

DROP TABLE EkaUser;