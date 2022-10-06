package net.softsociety.testboot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.testboot.domain.BoardVO;
import net.softsociety.testboot.domain.BoardWithName;
import net.softsociety.testboot.domain.ReplyVO;
import net.softsociety.testboot.domain.ReplyWithName;

@Mapper
public interface BoardDAO {
	
	//글저장
	public int writeBoard(BoardVO board);
	
	//글 개수
	public int count(HashMap<String, String> map);

	//글 전체 목록
	//public ArrayList<BoardVO> boardListAll(HashMap<String, String> map, RowBounds rb);
	public ArrayList<BoardWithName> boardListAll(HashMap<String, String> map, RowBounds rb);
	
	//글 읽기
	public BoardWithName writingRead(int boardnum);
	
	//조회수 증가
	public int updateHits(int boardnum);
	
	//인기글 목록
	public ArrayList<BoardWithName> hitListAll(HashMap<String, String> map, RowBounds rb);
	
	//글 삭제
	public int delete(BoardVO board);
	
	//해당 글의 댓글 목록 읽기
	public ArrayList<ReplyWithName> replyList(int board_id);
	
	//댓글 저장
	public int replyWrite(ReplyVO reply);
	

}
