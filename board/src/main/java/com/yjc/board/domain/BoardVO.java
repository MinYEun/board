package com.yjc.board.domain;

import lombok.Data;

@Data
public class BoardVO {
	private String board_id;	//�Խù���ȣ
	private String id;	//�Խù��ۼ���
	private String title;	//�Խù�����
	private String content;	//�Խù�����
	private String is_delete;	//�Խù���������
	private String file_name;	//÷������
}
