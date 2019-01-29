package com.qingsong.service;

import com.qingsong.SpringbootEsDemoApplicationTests;
import com.qingsong.entity.Book;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.settings.Settings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-29 14:46
 * @Version 1.0
 */
public class BookServiceTest extends SpringbootEsDemoApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void list() {
        List<AliasMetaData> aliasMetaData = elasticsearchTemplate.queryForAlias("book");
        List<Book> list = bookService.list();
        System.out.println(list);
    }
}