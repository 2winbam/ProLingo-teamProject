package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	
	private int board_id;
	private int user_id;
	private String title;
	private String board_content;
	private String writingdate;
	private String editdate;
	private int hits;
	private int likes;
	private int dislikes;
	private String originalfile;
	private String savedfile;
	
}

/*--PROLINGO_BOARD							
CREATE TABLE	PROLINGO_BOARD	(			
BOARD_ID	NUMBER	PRIMARY KEY		,	--게시글 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디
TITLE	VARCHAR2(100)		NOT NULL	,	--글 제목
BOARD_CONTENT	VARCHAR2(2000)		NOT NULL	,	--글 내용
WRITINGDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--작성 날짜
EDITDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--수정 날짜
HITS	NUMBER	DEFAULT '0'	NOT NULL	,	--조회수
LIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--추천
DISLIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--비추천
ORIGINALFILE	VARCHAR2(200)			,	--원본 파일 이름
SAVEDFILE	VARCHAR2(200)			);	--서버에 저장된 파일 이름
*/