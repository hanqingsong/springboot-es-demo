package com.qingsong.service;

import com.qingsong.entity.Book;
import com.qingsong.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-29 14:38
 * @Version 1.0
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    List<Book> list(){
        Iterable<Book> books = bookRepository.findAll();
        Book next = books.iterator().next();
        System.out.println(next);
        return null;
    }

}
