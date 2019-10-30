package com.yjc.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjc.board.domain.BoardVO;
import com.yjc.board.domain.MemberVO;
import com.yjc.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	//회원가입
	@RequestMapping("member/insertview.do")
	public String memberInsertView() {
		return "register";
	}
	
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO memberVO) {
		memberService.insertMember(memberVO);
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping("login.do")
	public String login() {
		return "login";
	}
	
	@RequestMapping("loginCheck.do")
	public String loginCheck(Model model, MemberVO memberVO, HttpSession session) {
		boolean result = memberService.loginCheck(memberVO, session);
		
		if(result == true) {
			model.addAttribute("msg", "success");
		} else {
			model.addAttribute("msg", "failure");
		}
		return "board";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		memberService.logout(session);
		model.addAttribute("msg", "logout");
		return "login";
	}
}
