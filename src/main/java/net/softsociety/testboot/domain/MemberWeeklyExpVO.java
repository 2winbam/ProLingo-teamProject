package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberWeeklyExpVO {

	private int user_id;
	private int mon_exp;
	private int tue_exp;
	private int wed_exp;
	private int thu_exp;
	private int fri_exp;
	private int sat_exp;
	private int sun_exp;
	// private int today;

}

/*--USER_WEEKLY_EXP						
DROP TABLE	USER_WEEKLY_EXP	;				
CREATE TABLE	USER_WEEKLY_EXP	(				
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	PRIMARY KEY	,	--멤버 아이디
MON_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--월	
TUE_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--화	
WED_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--수	
THU_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--목	
FRI_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--금	
SAT_EXP	NUMBER	DEFAULT 0	NOT NULL	,	--토	
SUN_EXP	NUMBER	DEFAULT 0	NOT NULL	);	--일	*/
