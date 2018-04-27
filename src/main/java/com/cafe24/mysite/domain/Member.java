package com.cafe24.mysite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cafe24.mysite.type.Gender;

@Entity
@Table( name = "member" )
public class Member {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @Column( name = "email", nullable = false, length = 200 )
    private String email;

    @Column( name = "password", nullable = false, length = 64 )
    private String password;

    @Enumerated( value = EnumType.STRING )
    @Column( name = "gender", nullable = false )
    private Gender gender;

    @Temporal( value = TemporalType.DATE )
    @Column( name = "join_date", nullable = false )
    private Date joinDate;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail( String email ) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword( String password ) {
	this.password = password;
    }

    public Gender getGender() {
	return gender;
    }

    public void setGender( Gender gender ) {
	this.gender = gender;
    }

    public Date getJoinDate() {
	return joinDate;
    }

    public void setJoinDate( Date joinDate ) {
	this.joinDate = joinDate;
    }

    @Override
    public String toString() {
	return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
		+ gender + ", joinDate=" + joinDate + "]";
    }

}
