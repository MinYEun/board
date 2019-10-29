package com.yjc.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yjc.board.domain.BoardVO;
import com.yjc.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String board(Model model) throws Exception {
		List<BoardVO> list = boardService.listAll();
		model.addAttribute("list", list);
		return "board";
	}
	
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO boardVO) throws Exception{
		boardService.create(boardVO);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="view.do")
	public String view(@RequestParam int bno, BoardVO boardVO, Model model, HttpSession session) throws Exception{
		boardService.increaseViewcnt(bno, session);
		
		model.addAttribute("view", boardVO);
		
		return "view";
	}
	
	@RequestMapping(value="update.do")
	public String update(@ModelAttribute BoardVO boardVO) throws Exception{
		boardService.update(boardVO);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="delete.do")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
