package net.softsociety.testboot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.softsociety.testboot.domain.ContentsVO;

@Mapper
public interface StudyCourseDAO {
	
	/**
	 * 학습선택 페이지에서 입문편 리스트 출력
	 * @return
	 */
	public ArrayList<ContentsVO> introdutionAll();
	
	/**
	 * 개념 슬라이드 출력
	 * @param lessonid 해당하는 레슨의 파라미터
	 * @return
	 */
	public ArrayList<ContentsVO> selectContents(int lessonid);

	public ArrayList<ContentsVO> selectContents2(@Param("lessonid")int lessonid, @Param("questionindex")int questionindex);

	public String getLanguage(int lessonid);
	
	/**
	 * 컴파일러 폼의 헤더리스트에서 현재 페이지의 타이틀을 조회
	 * @param lessonid
	 * @return 해당 컴파일러 폼 페이지의 타이틀
	 */
	
	public String searchTitle(int questionindex);
	
	/**
	 * prolingo_user 에서 마지막 로그인 일자 조회
	 * @param userid
	 * @return 마지막 로그인 일자
	 */
	
	public String selectLogDate(String userid);
	
	/**
	 * 누적 로그인 일자 조회
	 * @param userid 현재 접속해 있는 유저의 아이디
	 * @return 누적 일자
	 */
	
	public int selectDate(String userid);
	
	/**
	 * 로그인 1일차 업적
	 * @param userid
	 * @return
	 */
	
	public int achieveDayOne(String userid);
	
	/**
	 * 누적 로그인 날짜 +1
	 * @param accureMap
	 * @return 누적 로그인 일자 값
	 */
	
	public int plusDay(HashMap<String, Integer> accureMap);
	
	/**
	 * 오늘 날짜로 업데이트
	 * @param dateMap
	 * @return 
	 */
	
	public int updateLastDay(HashMap<String, String> dateMap);
	
	/**
	 * 누적 이틀 로그인 업적
	 * @param userid
	 * @return 
	 */
	
	public int achieveDayTwo(String userid);
	
	

	
	
}
