package com.qingsong.service;

import com.qingsong.entity.Book;
import com.qingsong.repository.BookRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
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

    /**
     * 列表
     * @return
     */
    List<Book> list(){
        Iterable<Book> books = bookRepository.findAll();
        Book next = books.iterator().next();
        List<Book> list = IteratorUtils.toList(books.iterator());
        return list;
    }

    /**
     * 总数
     * @return
     */
    long count(){
        long count = bookRepository.count();
        return count;
    }

    /**
     * 新增
     * @return
     */
    Book save(Book book){
        Book save = bookRepository.save(book);
        return save;
    }

    /**
     * 查询
     * @param kw
     * @return
     */
    public Page<Book> pageQuery(String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", kw))
                // .withPageable(PageRequest.of(1, 20))
                .build();
        return bookRepository.search(searchQuery);
    }

}
