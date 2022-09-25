package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProlingoKeywordVO {

	private int keyword_id;
	private String keyword_name;
	private String keyword_type;
}

/*--PROLINGO_KEYWORD					
CREATE TABLE	PROLINGO_KEYWORD	(			--키워드의 정보만 가지고 있고 다른 테이블이랑 관계 없는듯
KEYWORD_ID	NUMBER	PRIMARY KEY		,	--키워드 아이디
KEYWORD_NAME	VARCHAR2(20)		NOT NULL	,	--키워드 이름(FOR, WHILE 등)
KEYWORD_TYPE	VARCHAR2(20)		NOT NULL	);	--키워드 타입(반복문, 제어문 등)*/