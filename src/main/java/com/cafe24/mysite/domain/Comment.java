package com.cafe24.mysite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "comment" )
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;

    @Column( name = "content", nullable = false )
    private String content;
    @Temporal( value = TemporalType.DATE )
    @Column( name = "reg_date", nullable = false )
    private Date regDate;

    @ManyToOne
    @JoinColumn( name = "member_no", nullable = true )
    private Member member;

    @ManyToOne
    @JoinColumn( name = "board_no", nullable = false )
    private Board board;

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

    public Date getRegDate() {
	return regDate;
    }

    public void setRegDate( Date regDate ) {
	this.regDate = regDate;
    }

    public Member getMember() {
	return member;
    }

    public void setMember( Member member ) {
	this.member = member;
    }

    public Board getBoard() {
	return board;
    }

    public void setBoard( Board board ) {
	this.board = board;
    }

    @Override
    public String toString() {
	return "Comment [no=" + no + ", content=" + content + ", regDate=" + regDate + ", member=" + member + ", board="
		+ board + "]";
    }

}
