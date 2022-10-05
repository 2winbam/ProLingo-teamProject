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
	
	/**
	 * 입력된 검색어에 해당하지 않는 친구 조회
	 * @param searchWord
	 * @param userId
	 * @return
	 */
	public ArrayList<MemberVO> notfriends(String searchWord, String userId);
	
	/**
	 * 친구의 프로필 페이지 조회
	 * @param user_id
	 * @return
	 */
	public MemberVO selectFriend(String user_id);
	
	/**
	 * 친추 버튼을 누르면 친구추가
	 * @param target 친추 대상의 아이디
	 * @param userId 현재 로그인한 아이디
	 * @return
	 */
	public int followFriend(String target, String userId);
		
}
