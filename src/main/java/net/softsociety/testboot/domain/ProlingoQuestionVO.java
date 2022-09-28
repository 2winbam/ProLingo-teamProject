package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProlingoQuestionVO {

	private int question_id;
	private int lesson_id;
	private String question_contents;
	private String answer;
	private String keywords;
	private String default_code;
	private String console_result;
}

/*--PROLINGO_QUESTION								
CREATE TABLE	PROLINGO_QUESTION	(			
QUESTION_ID	NUMBER	PRIMARY KEY		,	--문제 아이디
LESSON_ID	NUMBER	REFERENCES PROLINGO_LESSON(LESSON_ID)	ON DELETE CASCADE	,	--학습 아이디
QUESTION_CONTENTS	VARCHAR2(2000)		NOT NULL	,	--문제 내용
ANSWER	VARCHAR2(2000)			,	--정답(콘솔 출력 내용 객관식에서는 직접 만들기?)
KEYWORDS	VARCHAR2(1000)			);	--채점 할 때 들어가 있어야 하는 문구(객관식에선 문제로 만드는용도)*/