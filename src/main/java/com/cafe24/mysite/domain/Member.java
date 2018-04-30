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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.mysite.type.Gender;
import com.cafe24.mysite.type.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "member" )
@Getter @Setter @ToString
public class Member {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;

    @NotEmpty @Length(min=2, max=10)
    @Column( name = "name", nullable = false, length = 10 )
    private String name;

    @NotEmpty @Email
    @Column( name = "email", nullable = false, length = 200 )
    private String email;

    @Column( name = "password", nullable = false, length = 64 )
    private String password;

    @Enumerated( value = EnumType.STRING )
    @Column( name = "gender", nullable = false, columnDefinition = "enum('male', 'female')" )
    private Gender gender;
    
    @Enumerated(value=EnumType.STRING)
    @Column(name="role", nullable=false, columnDefinition="enum('user', 'admin')")
    private Role role;

    @Temporal( value = TemporalType.TIMESTAMP )
    @Column( name = "join_date", nullable = false )
    private Date joinDate;

}
