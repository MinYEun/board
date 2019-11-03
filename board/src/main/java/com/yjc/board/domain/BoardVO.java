package com.yjc.board.domain;

import java.util.Date;

import lombok.Data;

public class BoardVO {
	private int bno;	//湲�踰덊샇
	private String title;	//�젣紐�
	private String content;	//�궡�슜
	private String writer; // 湲��벖�씠
	private int viewcnt;	//議고쉶�닔
	private Date regdate; //湲��옉�꽦�씪
	private int recnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
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
	
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" 
					+ regdate + ", viewcnt=" + viewcnt + "]";
	}
	
	
}
