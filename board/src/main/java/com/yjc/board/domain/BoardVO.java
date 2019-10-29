package com.yjc.board.domain;

import java.util.Date;

import lombok.Data;

public class BoardVO {
	private String bno;	//글번호
	private String title;	//제목
	private String content;	//내용
	private String writer; // 글쓴이
	private int viewcnt;	//조회수
	private Date regdate; //글작성일
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" 
					+ regdate + ", viewcnt=" + viewcnt + "]";
	}
	
	
}
