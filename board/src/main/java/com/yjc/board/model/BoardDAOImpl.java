package com.yjc.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yjc.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList("board.listAll");
	}
	
	@Override
	public void create(BoardVO boardVO) throws Exception {
		sqlSession.insert("board.insert", boardVO);
	}
	
	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("board.read", bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception{
		sqlSession.update("board.update", boardVO);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.delete", bno);
	}
	
	@Override
	public int increaseViewcnt(BoardVO boardVO) throws Exception {
		return sqlSession.update("board.increaseViewcnt", boardVO);
	}
		
	

}
