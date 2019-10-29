package com.yjc.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.yjc.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
//	private static final String NAMESPACE = "com.yjc.board.mapper.boardMapper";
	private final SqlSession sqlSession;
	
	@Inject
	public BoardServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BoardVO> boardList() throws Exception {
			return sqlSession.selectList("board.boardList");
	}
}
