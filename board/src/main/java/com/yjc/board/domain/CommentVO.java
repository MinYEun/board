package com.yjc.board.domain;

import lombok.Data;

@Data
public class CommentVO {
	private String comment_id; //´ñ±Û¹øÈ£
	private String content;	//´ñ±Û³»¿ë
	private String is_delete;	//´ñ±Û »èÁ¦¿©ºÎ
	private String id;	//´ñ±Û ÀÛ¼ºÀÚ
}
