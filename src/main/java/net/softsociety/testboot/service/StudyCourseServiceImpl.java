package net.softsociety.testboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.StudyCourseDAO;
import net.softsociety.testboot.domain.ContentsVO;


@Slf4j
@Service
public class StudyCourseServiceImpl implements StudyCourseService {
	
	@Autowired
	private StudyCourseDAO dao;
	
	/**
	 * 학습선택 페이지에서 개념편 리스트 전체 출력
	 */
	@Override
	public ArrayList<ContentsVO> introdutionAll(){
				
		ArrayList<ContentsVO> chapterList = dao.introdutionAll();
		
		log.debug("조회 완료 : {}", chapterList);
		 
		return chapterList;
	}
	/**
	 * 개념 슬라이드 조회
	 */
	@Override
	public ArrayList<ContentsVO> selectContents(int lessonid){
		
		ArrayList<ContentsVO> contentsList = dao.selectContents(lessonid);
		
		return contentsList;
	}

	@Override
	public ArrayList<ContentsVO> selectContents(int lessonid, int questionindex) {
		
		ArrayList<ContentsVO> contentsList = dao.selectContents2(lessonid, questionindex);
		
		return contentsList;
	}

	@Override
	public String getLanguage(int lessonid) {

		String result = dao.getLanguage(lessonid);
		
		return result;
	} 
	
	@Override
	public String searchTitle(int questionindex) {
		
		String title = dao.searchTitle(questionindex);
		
		return title;
	}

	/**
	 * 로그인 누적 일자
	 */

	@Override
	public int selectDate(String userid) {
		
		log.debug("impl로 넘어온 userid : {}",userid);
		
		// 누적 로그인 일수
		int accureDate = dao.selectDate(userid);
		
		log.debug("누적 로그인 일수 : {}", accureDate);
		
		// hashmap에서 쓰기위한 형변환 시도
		int userNum = Integer.parseInt(userid);
		
		// 마지막 로그인 날짜
		String lastLogin = dao.selectLogDate(userid);
		
		log.debug("마지막 로그인 날짜 : {}",lastLogin);
		
		// 현재 날짜
		LocalDateTime now = LocalDateTime.now();
		  // 포맷 정의        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");         
		// 포맷 적용        
		String formatedNow = now.format(formatter);
				
		log.debug("오늘 날짜 : {}", formatedNow);
		
		// 누적 로그인 수를 업데이트 하기 위한 hashmap
		HashMap<String, Integer> accureMap = new HashMap<String, Integer>();
		accureMap.put("userNum", userNum);
		accureMap.put("accureDate", accureDate);
		
		// 최종 로그인 일자를 업데이트 하기 위한 hashmap
		HashMap<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("userid", userid);
		dateMap.put("formatedNow", formatedNow);
		
		// 누적 로그인 일자가 0인경우 (로그인 업적 제공, 누적 로그인 일자 +1, 현재 로그인한 일자 등록)
		if(!formatedNow.equals(lastLogin)) {
			
			// 최종 로그인 일자 업데이트
			int updateDate = dao.updateLastDay(dateMap);
			
			// 누적 로그인 일자 +1
			int nowAccureDate = dao.plusDay(accureMap);
			log.debug("+1 한 후의 누적 로그인 : {}", nowAccureDate);
			
			if(updateDate == 1) {
				log.debug("로그인 일자 update 성공");
			}else if(updateDate == 0) {
				log.debug("로그인 일자 update 실패");
			}
			
			accureDate = dao.selectDate(userid);
			
			if(accureDate == 1) {
	
				// 로그인 업적 insert (출석 1일차)
				int insertAchieve = dao.achieveDayOne(userid);
			
				if(insertAchieve == 1) {
					log.debug("업적 insert 성공");
				}else if(insertAchieve == 0) {
					log.debug("업적 insert 실패");
				}
			
			}
			// 로그인 업적 insert (출석 2일차)
			else if(accureDate == 2) {
		
				// 로그인 업적 insert (출석 1일차)
				int insertAchieve = dao.achieveDayTwo(userid);
			
				if(insertAchieve == 1) {
					log.debug("업적 insert 성공");
				}else if(insertAchieve == 0) {
					log.debug("업적 insert 실패");
				}
			
			}
	}

		return accureDate;
	}

}
