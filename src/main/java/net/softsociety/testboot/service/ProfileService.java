package net.softsociety.testboot.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;

import net.softsociety.testboot.domain.AchievementVO;
import net.softsociety.testboot.domain.MemberVO;

public interface ProfileService {
	
	/**
	 * 클리어한 업적 조회
	 * @param userId 
	 * @return
	 */
	public ArrayList<AchievementVO> selectClear(String userId);
	
	/**
	 * 클리어 못한 업적 조회
	 * @param userId 
	 * @return
	 */
	public ArrayList<AchievementVO> selectNotClear(String userId);
	
	/**
	 * 입력된 검색어에 해당되는 친구 조회
	 * @param userId 
	 */
	public ArrayList<MemberVO> searchfriends(String searchWord, String userId);
		
}
