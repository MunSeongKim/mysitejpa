package com.cafe24.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmailAndPassword(String email, String password);
    Member findByEmail(String email);
    
    
    @Modifying	// for Update, Delete query
//    @Query(value="UPDATE Member m SET m.name=:name WHERE m.no=:no", nativeQuery=false)
    @Query(value="UPDATE Member m "
    	+ "SET m.name=:#{#member.name}, m.gender=:#{#member.gender} "
    	+ "WHERE m.no=:#{#member.no}", 
    	nativeQuery=false)
    int update(@Param("member") Member member);
    
//    @Query(value="UPDATE Member m SET m.name=:#{#user.name} WHERE m.no=:#{#user.no}", nativeQuery=false)
//    int updatePassword(@Param("member") Member member);
	
}
