package com.yjc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjc.board.domain.MemberVO;
import com.yjc.board.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO memberVO) {
		memberService.insertMember(memberVO);
		
		return "redirect:/";
	}
}
