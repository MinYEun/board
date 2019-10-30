package com.yjc.board.model;

import javax.servlet.http.HttpSession;

import com.yjc.board.domain.MemberVO;

public interface MemberDAO {
	//회원가입
	public void insertMember(MemberVO memberVO);
	
	public boolean loginCheck(MemberVO memberVO);
	
	public MemberVO viewMember(MemberVO memberVO);
	
	public void logout(HttpSession session);
}
