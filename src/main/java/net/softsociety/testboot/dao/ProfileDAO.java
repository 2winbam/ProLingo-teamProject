package net.softsociety.testboot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import net.softsociety.testboot.domain.AchievementVO;
import net.softsociety.testboot.domain.MemberVO;

@Mapper
public interface ProfileDAO {

	//클리어한 업적 조회
	public ArrayList<AchievementVO> selectClear(String userId);
	
	//클리어 못한 업적 조회
	public ArrayList<AchievementVO> selectNotClear(String userId);

	//입력된 검색어로 친구 조회
	public ArrayList<MemberVO> searchfriends(HashMap<String, String> friendMap);
	
	//입력된 검색어로 친구 등록되지 않은 사람 조회
	public ArrayList<MemberVO> notFriends(HashMap<String, String> unFriendMap);
	
	//친구의 프로필 조회
	public MemberVO selectFriend(String user_id);


}
