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
	public boolean loginCheck(MemberVO memberVO, HttpSession session) {
		boolean result = memberDao.loginCheck(memberVO);
		if(result) {
			MemberVO memberVO2 = viewMember(memberVO);
			//세션 변수 등록
			session.setAttribute("user_id", memberVO2.getUser_id());
			session.setAttribute("password", memberVO2.getPassword());
		}
		return result;
	}
	
	@Override
	public void logout(HttpSession session) {
		//세션 초기화
		session.invalidate();
	}
}
