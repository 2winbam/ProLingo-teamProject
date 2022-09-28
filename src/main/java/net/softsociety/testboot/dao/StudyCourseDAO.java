package net.softsociety.testboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.softsociety.testboot.domain.ContentsVO;
import net.softsociety.testboot.domain.TestLessonVO;

@Mapper
public interface StudyCourseDAO {
	
	/**
	 * 학습선택 페이지에서 입문편 리스트 출력
	 * @return
	 */
	public ArrayList<TestLessonVO> introdutionAll();
	
	/**
	 * 개념 슬라이드 출력
	 * @param lessonid 해당하는 레슨의 파라미터
	 * @return
	 */
	public ArrayList<ContentsVO> selectContents(int lessonid);

	public ArrayList<ContentsVO> selectContents2(@Param("lessonid")int lessonid, @Param("questionindex")int questionindex);
	
}
