package com.yjc.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String user_id;
	private String password;
	private String user_name;
	private String email;
	private Date user_regdate;
}
