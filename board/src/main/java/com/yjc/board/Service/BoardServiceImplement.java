package com.yjc.board.Service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.yjc.board.domain.BoardVO;

@Service
public class BoardServiceImplement implements BoardService{
//	private static final String NAMESPACE = "com.yjc.board.mapper.boardMapper";
	private final SqlSession sqlSession;
	
	@Inject
	public BoardServiceImplement(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BoardVO> boardList() throws Exception {
			return sqlSession.selectList("board.boardList");
	}
}
