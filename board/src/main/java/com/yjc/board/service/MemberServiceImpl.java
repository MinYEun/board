package com.yjc.board.service;

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
}
