package com.cafe24.mysite.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.domain.Guestbook;

@Repository
public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
    List<Guestbook> findAllByOrderByRegDateDesc();
    
    @Query("SELECT gb FROM Guestbook gb WHERE gb.no > :startNo")
    Page<Guestbook> findAllByStartNo(@Param("startNo") Long startNo, Pageable pageable);
}
