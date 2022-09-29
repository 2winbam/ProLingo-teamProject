package net.softsociety.testboot.dao;

import java.util.ArrayList;

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
	
	/**
	 * 컴파일러 폼의 헤더리스트에서 현재 페이지의 타이틀을 조회
	 * @param lessonid
	 * @return 해당 컴파일러 폼 페이지의 타이틀
	 */
	public String searchTitle(int questionindex);
	
}
