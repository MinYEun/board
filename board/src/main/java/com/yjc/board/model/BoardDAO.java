package com.yjc.board.model;

import java.util.List;

import com.yjc.board.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	
	public void create(BoardVO boardVO) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void increaseViewcnt(int bno) throws Exception;
}
