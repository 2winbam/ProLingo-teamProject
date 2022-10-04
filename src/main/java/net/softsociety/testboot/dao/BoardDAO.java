package net.softsociety.testboot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.testboot.domain.BoardVO;
import net.softsociety.testboot.domain.BoardWithName;

@Mapper
public interface BoardDAO {
	
	//글저장
	public int writeBoard(BoardVO board);
	
	//글 개수
	public int count(HashMap<String, String> map);

	//글 전체 목록
	//public ArrayList<BoardVO> boardListAll(HashMap<String, String> map, RowBounds rb);
	public ArrayList<BoardWithName> boardListAll(HashMap<String, String> map, RowBounds rb);

}
