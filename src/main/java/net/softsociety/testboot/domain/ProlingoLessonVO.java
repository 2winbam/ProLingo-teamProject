package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProlingoLessonVO {

	private int lesson_id;
	private int subject_id;
	private String grade;
	private String lesson_contents;
}

/*--PROLINGO_LESSON					
CREATE TABLE	PROLINGO_LESSON	(			
LESSON_ID	NUMBER	PRIMARY KEY		,	--학습 아이디(직접?)
SUBJECT_ID	NUMBER	REFERENCES PROLINGO_SUBJECT(SUBJECT_ID)	ON DELETE CASCADE	,	--과목 아이디
GRADE	VARCHAR2(20)	CHECK(GRADE IN('INTRODUTION', 'BEGINNER'))	NOT NULL	,	--과정 등급
LESSON_CONTENTS	VARCHAR2(2000)		NOT NULL	);	--개념, 어떻게 넣을것인지? 이미지로?*/
