--과목
CREATE TABLE SubjectCategory(
	scid 			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	subjectcate		VARCHAR(10) 	NOT NULL
);

SELECT * FROM SubjectCategory;

INSERT INTO SubjectCategory(subjectcate) VALUES("국어");
INSERT INTO SubjectCategory(subjectcate) VALUES("수학");
INSERT INTO SubjectCategory(subjectcate) VALUES("사회");
INSERT INTO SubjectCategory(subjectcate) VALUES("과학");
INSERT INTO SubjectCategory(subjectcate) VALUES("영어");