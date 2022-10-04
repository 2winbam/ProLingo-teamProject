package net.softsociety.testboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.BoardDAO;
import net.softsociety.testboot.domain.BoardVO;
import net.softsociety.testboot.domain.BoardWithName;
import net.softsociety.testboot.domain.PageNavigator;

@Slf4j
@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	//글저장
	@Override
	public int writeBoard(BoardVO board) {
		log.debug("called BoardServiceImple writeBoard()");
		int result = boardDAO.writeBoard(board);
		log.debug("결과:{}", result);
		return result;
	}
	
	//글 개수
	@Override
	public PageNavigator getgetPageNavigator(int pagePerGroup, int countPerPage, int page, String type,
			String searchWord) {
		log.debug("called serviceImple PageNavigator()");
		HashMap<String,String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchWord", searchWord);
		
		int total = boardDAO.count(map);
		PageNavigator navi = new PageNavigator(pagePerGroup, countPerPage, page, total);
		
		return navi;
	}
	
	//글 전체 목록
	@Override
	//public ArrayList<BoardVO> boardListAll(PageNavigator navi, String type, String searchWord) {
	public ArrayList<BoardWithName> boardListAll(PageNavigator navi, String type, String searchWord) {
		log.debug("ServiceImple boardListAll called()");
		log.debug("navi : {}, type : {}, searchWord : {}", navi, type, searchWord);
		HashMap<String, String> map = new HashMap<>();
		map.put("type",type);
		map.put("searchWord", searchWord); //Map에 담을 때 이름으로 꺼내서 써야 함. "type", "searchWord"
		
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
		
		ArrayList<BoardWithName> boardLsit = boardDAO.boardListAll(map, rb);
		
		
		return boardLsit;
		
	}
	
	
	
}
