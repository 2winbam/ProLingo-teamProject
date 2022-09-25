package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {

	private int reply_id;
	private String reply_content;
	private int board_id;
	private int user_id;
	private int target_id;
	private String writingdate;
}

/*--PROLINGO_REPLY								
CREATE TABLE	PROLINGO_REPLY	(			
REPLY_ID	NUMBER	PRIMARY KEY		,	--댓글 아이디
REPLY_CONTENT	VARCHAR2(600)		NOT NULL	,	--댓글 내용
BOARD_ID	NUMBER	REFERENCES PROLINGO_BOARD(BOARD_ID)	ON DELETE CASCADE	,	--댓글이 작성된 게시글 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--댓글을 작성한 유저 아이디
TARGET_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--대댓 대상
WRITINGDATE	DATE	DEFAULT 'SYSDATE'	NOT NULL	);	--댓글 작성 날짜*/