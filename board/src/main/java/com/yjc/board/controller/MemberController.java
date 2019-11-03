package com.yjc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yjc.board.domain.BoardVO;
import com.yjc.board.domain.MemberVO;
import com.yjc.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	//�쉶�썝媛��엯
	@RequestMapping("insertview.do")
	public String memberInsertView(@ModelAttribute MemberVO memberVO) {
		return "register";
	}
	
	@RequestMapping("insert.do")
	public String memberInsert(@ModelAttribute MemberVO memberVO) {
		memberService.insertMember(memberVO);
		
		return "redirect:/member/login.do";
	}
	
	//濡쒓렇�씤
	@RequestMapping("login.do")
	public String login(HttpServletRequest request) {

		return "login";
	}
	
	@RequestMapping("loginCheck.do")
	public String loginCheck(Model model, MemberVO memberVO, HttpSession session, HttpServletRequest request) {		
		request.getSession().setAttribute("logininfo", true);
		session.setAttribute("user_id", memberVO.getUser_id());
		
		
		MemberVO member = memberService.loginCheck(memberVO, session);

		if(member != null) {
			return "redirect:/board/list.do";
		} else {

			return "redirect:/member/login.do";
		}
		
	}
	
	//濡쒓렇�븘�썐
	@RequestMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		memberService.logout(session);
		model.addAttribute("msg", "logout");
		return "login";
	}
}
