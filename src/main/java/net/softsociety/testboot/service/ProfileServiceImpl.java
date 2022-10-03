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
	
	@Override
	public ArrayList<MemberVO> searchList(String searchWord, String userId){
		
		log.debug("userid : {}", userId);
		
		/*
		// 아이디와 검색어로 친구목록 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put(userId, searchWord);
		
		//log.debug("map의 usrId : {}", map.get(userId));
		log.debug("map의 searchWord : {}", map.get(searchWord));
		
		// 위에서 조회된 리스트에서 검색어에 해당하는 값을 출력
		ArrayList<MemberVO> findResult = dao.selectFriends(map);
		*/
		// 아이디를 입력 받아 해당 아이디와 친구를 제외한 목록을 조회
		ArrayList<MemberVO> memberList = dao.searchList(searchWord);
				
		return memberList;
	}
	
}
