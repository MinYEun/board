package com.yjc.board.domain;

import lombok.Data;

@Data
public class BoardVO {
	private String board_id;	//게시물번호
	private String id;	//게시물작성자
	private String title;	//게시물제목
	private String content;	//게시물내용
	private String is_delete;	//게시물삭제여부
	private String file_name;	//첨부파일
}
