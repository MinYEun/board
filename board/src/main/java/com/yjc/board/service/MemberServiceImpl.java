package com.yjc.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjc.board.domain.MemberVO;
import com.yjc.board.model.MemberDAOImpl;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAOImpl memberDao;
	
	@Override
	public void insertMember(MemberVO memberVO) {
		memberDao.insertMember(memberVO);
	}
	
	@Override
	public MemberVO viewMember(MemberVO memberVO) {
		return memberDao.viewMember(memberVO);
	}
	
	@Override
	public MemberVO loginCheck(MemberVO memberVO, HttpSession session) {
		MemberVO member = memberDao.loginCheck(memberVO);
		if(member != null) {
			//세션 변수 등록
			session.setAttribute("user_id", member.getUser_id());
			session.setAttribute("user_name", member.getUser_name());
			session.setAttribute("email", member.getEmail());
		}

		return member;
	}
	
	@Override
	public void logout(HttpSession session) {
		//세션 초기화
		session.invalidate();
	}
}
