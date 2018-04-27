package com.cafe24.mysite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "guestbook" )
@Getter
@Setter
@ToString
public class Guestbook {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;
    
    @Column( name = "name", nullable = false, length = 50 )
    private String name;
    
    @Column( name = "password", nullable = false, length = 64 )
    private String password;
    
    @Lob
    @Column( name = "content", nullable = false )
    private String content;
    
    @Temporal( value = TemporalType.DATE )
    @Column( name = "reg_date", nullable = false )
    private Date regDate;

}
