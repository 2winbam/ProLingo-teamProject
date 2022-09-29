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
	public ArrayList<AchievementVO> selectClear(){
		
		ArrayList<AchievementVO> clearList = dao.selectClear();
		
		return clearList;
	}
	
	/**
	 * 클리어 못한 업적 조회
	 */
	@Override
	public ArrayList<AchievementVO> selectNotClear(){
		
		ArrayList<AchievementVO> notClearList = dao.selectNotClear();
		
		return notClearList;
	}
}
