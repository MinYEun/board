package com.yjc.board.model;

import com.yjc.board.domain.MemberVO;

public interface MemberDAO {
	//회원가입
	public void insertMember(MemberVO memberVO);
}
