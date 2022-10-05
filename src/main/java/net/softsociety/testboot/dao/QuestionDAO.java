package net.softsociety.testboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.testboot.domain.ProlingoKeywordVO;
import net.softsociety.testboot.domain.ProlingoQuestionVO;

@Mapper
public interface QuestionDAO {

	ArrayList<ProlingoQuestionVO> selectAllQuestionsByLessonID(int lessonid);

	ProlingoKeywordVO selectKeywordById(int keywordid);

	ArrayList<ProlingoKeywordVO> selectKeywordsByType(String type);

}
