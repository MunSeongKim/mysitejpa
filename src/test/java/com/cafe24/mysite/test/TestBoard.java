package com.cafe24.mysite.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.mysite.domain.Board;
import com.cafe24.mysite.repository.BoardRepository;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestBoard {
    @Autowired
//    private BoardService boardService;
    private BoardRepository boardRepository;

    @Test
    public void test01_getList() {
	Page<Board> result = boardRepository.findAllByTitleOrContentContaining( "", new PageRequest(0, 2, Direction.DESC, "regDate"));
	assertNotNull("result is null", result);
	assertTrue( result.hasContent() );
	
    }

}
