package com.cafe24.mysite.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.domain.Guestbook;

@Repository
public interface GuestbookRepository extends CrudRepository<Guestbook, Long> {

}
