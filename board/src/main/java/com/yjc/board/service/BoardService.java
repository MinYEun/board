package com.yjc.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjc.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> listAll() throws Exception;
	
	public void create(BoardVO boardVO) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public int increaseViewcnt(BoardVO boardVO) throws Exception;
	
}
