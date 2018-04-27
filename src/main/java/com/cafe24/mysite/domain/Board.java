package com.cafe24.mysite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "board" )
public class Board {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;

    @Column( name = "title", nullable = false, length = 100 )
    private String title;

    @Lob
    @Column( name = "content", nullable = false )
    private String content;

    @Column( name = "hit_count", nullable = false )
    private Integer hitCount;

    @Temporal( value = TemporalType.DATE )
    @Column( name = "reg_date", nullable = false )
    private Date regDate;

    @Column( name = "group_no", nullable = false )
    private Integer groupNo;
    @Column( name = "order_no", nullable = false )
    private Integer orderNo;
    @Column( name = "depth", nullable = false )
    private Integer depth;

    @ManyToOne
    @JoinColumn( name = "member_no", nullable = true )
    private Member member;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle( String title ) {
	this.title = title;
    }

    public String getContent() {
	return content;
    }

    public void setContent( String content ) {
	this.content = content;
    }

    public Integer getHitCount() {
	return hitCount;
    }

    public void setHitCount( Integer hitCount ) {
	this.hitCount = hitCount;
    }

    public Date getRegDate() {
	return regDate;
    }

    public void setRegDate( Date regDate ) {
	this.regDate = regDate;
    }

    public Integer getGroupNo() {
	return groupNo;
    }

    public void setGroupNo( Integer groupNo ) {
	this.groupNo = groupNo;
    }

    public Integer getOrderNo() {
	return orderNo;
    }

    public void setOrderNo( Integer orderNo ) {
	this.orderNo = orderNo;
    }

    public Integer getDepth() {
	return depth;
    }

    public void setDepth( Integer depth ) {
	this.depth = depth;
    }

    public Member getMember() {
	return member;
    }

    public void setMember( Member member ) {
	this.member = member;
    }

    @Override
    public String toString() {
	return "Board [no=" + no + ", title=" + title + ", content=" + content + ", hitCount=" + hitCount + ", regDate="
		+ regDate + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", member=" + member
		+ "]";
    }

}
