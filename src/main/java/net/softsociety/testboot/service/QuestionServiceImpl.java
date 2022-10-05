package net.softsociety.testboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.testboot.dao.QuestionDAO;
import net.softsociety.testboot.domain.ProlingoKeywordVO;
import net.softsociety.testboot.domain.ProlingoQuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDAO dao;

	@Override
	public ArrayList<ProlingoQuestionVO> selectAllQuestionsByLessonID(int lessonid) {
		return dao.selectAllQuestionsByLessonID(lessonid);
	}

	@Override
	public ArrayList<ProlingoKeywordVO> selectAllKeywords(String keywords) {
		
		String[] keywordlist = keywords.split(",");
		
		ArrayList<ProlingoKeywordVO> result = new ArrayList<>();
		
		for(String key : keywordlist) {
			//nteger.parseInt(key);
			result.add(dao.selectKeywordById(Integer.parseInt(key)));
		}

		return result;
	}

	@Override
	public ArrayList<ProlingoKeywordVO> selectSameTypeKeywords(String type) {
		ArrayList<ProlingoKeywordVO> result = new ArrayList<>();
		
		result = dao.selectKeywordsByType(type);

		return result;
	}
}
