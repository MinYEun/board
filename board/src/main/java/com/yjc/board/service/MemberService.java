package com.yjc.board.service;

import javax.servlet.http.HttpSession;

import com.yjc.board.domain.MemberVO;;

public interface MemberService {
	//회원가입
	public void insertMember(MemberVO memberVO);
	
	public boolean loginCheck(MemberVO memberVO, HttpSession session);
	
	public MemberVO viewMember(MemberVO memberVO);
	
	public void logout(HttpSession session);
}
