package com.cafe24.mysite.vo;

public class CommentVO {
    private Long no;
    private String content;
    private String regDate;
    private Long userNo;
    private Long boardNo;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getContent() {
	return content;
    }

    public void setContent( String content ) {
	this.content = content;
    }

    public String getRegDate() {
	return regDate;
    }

    public void setRegDate( String regDate ) {
	this.regDate = regDate;
    }

    public Long getUserNo() {
	return userNo;
    }

    public void setUserNo( Long userNo ) {
	this.userNo = userNo;
    }

    public Long getBoardNo() {
	return boardNo;
    }

    public void setBoardNo( Long boardNo ) {
	this.boardNo = boardNo;
    }

    @Override
    public String toString() {
	return "CommentVO [no=" + no + ", content=" + content + ", regDate=" + regDate + ", userNo=" + userNo
		+ ", boardNo=" + boardNo + "]";
    }

}
