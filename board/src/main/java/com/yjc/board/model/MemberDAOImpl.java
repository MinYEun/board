package com.yjc.board.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yjc.board.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("member.insertMember", memberVO);
	}
}
