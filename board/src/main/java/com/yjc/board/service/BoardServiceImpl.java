package com.yjc.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjc.board.domain.BoardVO;
import com.yjc.board.model.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
//	private static final String NAMESPACE = "com.yjc.board.mapper.boardMapper";
	
	@Autowired
	BoardDAO boardDao;

	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}
	
	@Override
	public void create(BoardVO boardVO) throws Exception{
		String title = boardVO.getTitle();
		String content = boardVO.getContent();
		String writer = boardVO.getWriter();
		
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setWriter(writer);

		boardDao.create(boardVO);

	}
	
	@Override
	public BoardVO read(int bno) throws Exception{
		return boardDao.read(bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDao.update(boardVO);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
	@Override
	public int increaseViewcnt(BoardVO boardVO) throws Exception {
		return boardDao.increaseViewcnt(boardVO);
	}
}
