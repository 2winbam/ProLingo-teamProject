package net.softsociety.testboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.ProfileDAO;
import net.softsociety.testboot.domain.AchievementVO;
import net.softsociety.testboot.domain.MemberVO;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileDAO dao;
	
	/**
	 * 클리어한 업적 조회
	 */
	@Override
	public ArrayList<AchievementVO> selectClear(String userId){
		
		ArrayList<AchievementVO> clearList = dao.selectClear(userId);
		
		return clearList;
	}
	
	/**
	 * 클리어 못한 업적 조회
	 */
	@Override
	public ArrayList<AchievementVO> selectNotClear(String userId){
		
		ArrayList<AchievementVO> clearList = dao.selectClear(userId);
		ArrayList<AchievementVO> notClearList = dao.selectNotClear(userId);
		
		log.debug("모든 업적 : {}", notClearList);
		
		for(AchievementVO cl : clearList) {
			int i = 0;
			for(AchievementVO ncl : notClearList) {
				log.debug("cl : " + cl.getAchievement_id());
				log.debug("ncl : " + ncl.getAchievement_id());
				if(cl.getAchievement_id() == ncl.getAchievement_id()) {
					//log.debug("" + i);
					notClearList.remove(i);
					break;
				}
				i++;
			}
		}
		log.debug("뺀 업적 : {}", notClearList);
		
		return notClearList;
	}
	
	/**
	 * 입력된 이메일을 가진 친구를 조회
	 */
	@Override
	public ArrayList<MemberVO> searchfriends(String searchWord, String userId){
		
		log.debug("친구찾기의 impl userid : {}", userId);
		log.debug("친구찾기의 impl searchWord : {}", searchWord);
		
		// 아이디와 검색어로 친구목록 조회
		HashMap<String, String> friendMap = new HashMap<String, String>();
		friendMap.put("userId", userId);
		friendMap.put("searchWord", searchWord);
		
		log.debug("map의 userid : {}", friendMap.get("userId"));
		log.debug("map의 searchWord : {}", friendMap.get("searchWord"));
		
		// 해당 검색어를 가진 친구 목록을 조회
		ArrayList<MemberVO> friendList = dao.searchfriends(friendMap);
		
		log.debug("조회한 친구 리스트 : {}",friendList);
		
		return friendList;
	}
	
	/**
	 * 입력된 이메일을 가진 친국가 아닌 사람 조회
	 */
	public ArrayList<MemberVO> notfriends(String searchWord, String userId){
		
		log.debug("친구아닌 impl userid : {}", userId);
		log.debug("친구아닌 impl searchWord : {}", searchWord);
		
		// 아이디와 검색어로 친구목록 조회
		HashMap<String, String> friendMap = new HashMap<String, String>();
		friendMap.put("userId", userId);
		friendMap.put("searchWord", searchWord);
				
		log.debug("map의 userid : {}", friendMap.get("userId"));
		log.debug("map의 searchWord : {}", friendMap.get("searchWord"));
				
		// 해당 검색어를 가진 친구 목록을 조회
		ArrayList<MemberVO> friendList = dao.searchfriends(friendMap);
		
		
		//아이디와 검색어로 친구가 아닌 사람조회
		HashMap<String, String> unFriendMap = new HashMap<String, String>();
		unFriendMap.put("userId", userId);
		unFriendMap.put("searchWord", searchWord);
		
		log.debug("친구아닌 map userid : {}", unFriendMap.get("userId"));
		log.debug("친구아닌 map searchWord : {}", unFriendMap.get("searchWord"));
		
		ArrayList<MemberVO> unFriendList = dao.notFriends(unFriendMap);
		
		
		for(MemberVO ml : friendList) {
			int i = 0;
			for(MemberVO nml : unFriendList) {
				log.debug("cl : " + ml.getUser_id());
				log.debug("ncl : " + nml.getUser_id());
				if(ml.getUser_id() == nml.getUser_id()) {
					//log.debug("" + i);
					unFriendList.remove(i);
					break;
				}
				i++;
			}
		}
		log.debug("뺀 리스트 : {}", unFriendList);
		
		return unFriendList;
	}
	
	// 친구의 프로필 조회
	public MemberVO selectFriend(String user_id) {
		
		MemberVO friendInfo = dao.selectFriend(user_id);
		
		return friendInfo;
	}
	//내 프로필에 친구조회
	@Override
	public ArrayList<MemberVO> selectAllFriends(String userId) {

		ArrayList<MemberVO> friendsInfo = dao.selectAllFriends(userId);
		return friendsInfo;
	}
}
