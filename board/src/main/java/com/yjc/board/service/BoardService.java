package com.yjc.board.service;

import java.util.List;

import com.yjc.board.domain.BoardVO;

public interface BoardService {
	List<BoardVO> boardList() throws Exception;
}
