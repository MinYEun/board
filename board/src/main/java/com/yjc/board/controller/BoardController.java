package com.yjc.board.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
		return "/board/list";
	}
	
	@RequestMapping(value="write.do")
	public String write() throws Exception {
		return "/board/write";
	}
	
	@RequestMapping(value="insert.do")
	public String insert(@ModelAttribute BoardVO boardVO, HttpServletRequest request,  Model model) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		model.addAttribute("list", boardVO);
		boardService.create(boardVO);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="view.do")
	public String view(@RequestParam int bno, BoardVO boardVO, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		/* boardService.increaseViewcnt(bno, session); */
		BoardVO data = boardService.read(bno);
		model.addAttribute("view", data);
		
		String memberId = (String) session.getAttribute("user_id");
		String writerId = data.getWriter();
		System.out.println(memberId+", "+writerId);
		
		if (!writerId.equals(memberId)) {

			Cookie[] cookies = request.getCookies();

			//���ϱ� ���� ���ο� ��Ű ����
			Cookie viewCookie = null;

			//��Ű�� ���� ���
			if (cookies != null && cookies.length > 0) {
				for (int i = 0; i < cookies.length; i++) {
					// ��Ű�� name�� ��Ű + bno�� ��ġ�ϴ� ��Ű�� viewCookie�� �־���
					if (cookies[i].getName().equals("cookie" + boardVO.getBno())) {
						viewCookie = cookies[i];
					}
				}
			}
			//viewCookie�� null ��� ��Ű �����Ͽ� ��ȸ�� ���� ���� ó��
			if (viewCookie == null) {
				System.out.println("cookie ����");
				//��Ű ����
				Cookie newCookie = new Cookie("cookie" + boardVO.getBno(), "|" + boardVO.getBno() + "|");
				//��Ű �߰�
				response.addCookie(newCookie);
				//��ȸ�� ����
				int result = boardService.increaseViewcnt(boardVO);
				// viewCookie�� null�� �ƴ� ��� ��ȸ�� ���� ��������.
				if (result > 0) {
					System.out.println("��ȸ�� ����");
				} else {
					System.out.println("��ȸ�� ����");
				}
			} else {
				System.out.println("cookie ����");
				String value = viewCookie.getValue();
				System.out.println("cookie �� : " + value);
			}
		}		
		return "/board/view";
	}
	
	@RequestMapping(value="update.do")
	public String update(@ModelAttribute BoardVO boardVO) throws Exception{
		boardService.update(boardVO);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="delete.do")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		return "redirect:/board/list.do";
	}
}
