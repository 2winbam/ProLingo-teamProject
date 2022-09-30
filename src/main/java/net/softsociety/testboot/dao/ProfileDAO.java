package net.softsociety.testboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import net.softsociety.testboot.domain.AchievementVO;

@Mapper
public interface ProfileDAO {

	//클리어한 업적 조회
	public ArrayList<AchievementVO> selectClear(String userId);
	
	//클리어 못한 업적 조회
	public ArrayList<AchievementVO> selectNotClear(String userId);
}
