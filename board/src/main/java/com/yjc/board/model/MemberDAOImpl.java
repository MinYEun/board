package com.yjc.board.model;

import javax.servlet.http.HttpSession;

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

	@Override
	public MemberVO loginCheck(MemberVO memberVO) {
		
		return sqlSession.selectOne("member.loginCheck", memberVO);
	}

	@Override
	public MemberVO viewMember(MemberVO memberVO) {
		return sqlSession.selectOne("member.viewMember", memberVO);
	}

	@Override
	public void logout(HttpSession session) {		
	}
	
	
}
