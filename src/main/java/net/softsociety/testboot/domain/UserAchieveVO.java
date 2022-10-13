package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAchieveVO {
	private int user_id; // 유저 아이디
	private int achievement_id; // 달성한 업적 아이디
	private String achievement_date; // 업적 달성 시간

}
/*
 * CREATE TABLE USER_ACHIEVE ( USER_ID NUMBER REFERENCES PROLINGO_USER(USER_ID)
 * ON DELETE CASCADE , --유저 아이디 ACHIEVEMENT_ID NUMBER REFERENCES
 * PROLINGO_ACHIEVEMENT(ACHIEVEMENT_ID) ON DELETE CASCADE , --달성한 업적 아이디
 * ACHIEVEMENT_DATE DATE DEFAULT SYSDATE, -- 업적달성 시간 PRIMARY KEY(USER_ID,
 * ACHIEVEMENT_ID) );
 */