package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementVO {

	private int achievement_id;
	private String achievement_name;
	private String achievement_text;
}

/*--PROLINGO_ACHIEVEMENT								
CREATE TABLE	PROLINGO_ACHIEVEMENT	(		--시퀀스 필요하면 만드는걸로	
ACHIEVEMENT_ID	NUMBER	PRIMARY KEY	,	--업적 아이디	
ACHIEVEMENT_NAME	VARCHAR2(100)	NOT NULL	,	--업적 이름	
ACHIEVEMENT_TEXT	VARCHAR2(1000)	NOT NULL	);	--업적 내용	*/