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
		
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		
		// 공백문자 처리
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		
		//줄바꿈 처리
		content = content.replace("\n", "<br>");
		
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
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		//세션에 저장된 조회시간 검색
		//최초로 조회할 경우 세션에 저장된 값 없기 때문에 if문실행X
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time = (long)session.getAttribute("update_time_" + bno);
		}
	}
}
