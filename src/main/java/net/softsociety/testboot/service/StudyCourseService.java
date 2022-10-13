package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.ContentsVO;

public interface StudyCourseService {

	/**
	 * 학습선택 페이지에서 입문편 리스트 전체출력
	 * 
	 * @return
	 */
	public ArrayList<ContentsVO> introdutionAll();

	/**
	 * 개념 슬라이드 출력
	 * 
	 * @param lessonid 해당 값과 lesson_id 가 같으면 해당 슬라이드 실행
	 * @return 해당 슬라이드 리스트
	 */
	public ArrayList<ContentsVO> selectContents(int lessonid);

	public ArrayList<ContentsVO> selectContents(int lessonid, int questionindex);

	// 레슨의 언어 반환
	public String getLanguage(int lessonid);

	/**
	 * 컴파일러 폼의 헤더리스트에서 현재 페이지의 타이틀을 조회
	 * 
	 * @param questionindex
	 * @return 해당 컴파일러 폼 페이지의 타이틀
	 */
	public String searchTitle(int questionindex);

	/**
	 * 누적 로그인 일수 조회
	 * 
	 * @param userId
	 * @return 누적 로그인 일수
	 */
	public int selectDate(String userId);

}
