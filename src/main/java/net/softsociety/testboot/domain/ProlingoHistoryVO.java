package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProlingoHistoryVO {

	private int history_id;
	private int user_id;
	private int question_id;
	private String history_content;
}

/*--PROLINGO_HISTORY					
CREATE TABLE	PROLINGO_HISTORY	(			
HISTORY_ID	NUMBER	PRIMARY KEY		,	--풀이 내역 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디
QUESTION_ID	NUMBER	REFERENCES PROLINGO_QUESTION(QUESTION_ID)	ON DELETE CASCADE	,	--문제 아이디
HISTORY_CONTENT	VARCHAR2(2000)		NOT NULL	);	--풀이 내용*/