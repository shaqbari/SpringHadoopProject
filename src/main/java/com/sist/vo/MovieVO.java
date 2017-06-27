package com.sist.vo;

/**
 * @author sist
 *	null이 긁혀올 가능성이 높으므로 자료형을 String으로 우선 잡고 필요할때 int로변경하자
 *
 *	package
 *	1) model => @Controller
 *  2) vo => 사용자 정의 데이터형
 *  3) manager
 *  4) database
 *  
 */
public class MovieVO {
	private int mno;
	private String title;
	private String poster;
	private String reserve;
	private String regdate;
	private String like;
	private String link;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}






