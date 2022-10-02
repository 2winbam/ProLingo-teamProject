package net.softsociety.testboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.ProfileDAO;
import net.softsociety.testboot.domain.AchievementVO;

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
}
