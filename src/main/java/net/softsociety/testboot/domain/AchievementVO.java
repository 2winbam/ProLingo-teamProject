package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementVO {

	private int achievement_id;					// 업적 아이디(시퀀스 nextval)
	private String achievement_name;			// 업적 이름
	private String achievement_text;			// 업적 내용
	private String achievement_picture;			// 업적 사진
	private String achievement_date;			// 데이터베이스에서는 UserAchieve의 값이지만, 업적페이지에서의 달성시간 표기를 위해 vo에 추가함
}
/*
--PROLINGO_ACHIEVEMENT					
DROP TABLE	PROLINGO_ACHIEVEMENT	;			
CREATE TABLE	PROLINGO_ACHIEVEMENT	(		    	
ACHIEVEMENT_ID	    NUMBER	PRIMARY KEY	,	        -- 업적 아이디	(시퀀스 NEXTVAL)
ACHIEVEMENT_NAME	VARCHAR2(100)	NOT NULL	,	-- 업적이름	
ACHIEVEMENT_TEXT	VARCHAR2(1000)	NOT NULL	,	-- 업적내용
ACHIEVEMENT_PICTURE VARCHAR2(200)   NOT NULL        -- 업적사진 경로(img/achievements 폴더 안의 사진)
);
*/