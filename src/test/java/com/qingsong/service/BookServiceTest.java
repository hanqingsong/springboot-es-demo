package com.qingsong.service;

import com.qingsong.SpringbootEsDemoApplicationTests;
import com.qingsong.entity.Book;
import com.qingsong.entity.UserComment;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.settings.Settings;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private UserCommentService userCommentService;
    @Test
    public void list() {
        UserComment.UserCommentBuilder builder = UserComment.builder()
                .commentId(1L)
                .themeId(1L)
                .userId(1L)
                .type(1)
                .status(1)
                .content("内容")
                .createTime(DateTime.now().toDate())
                .updateTime(DateTime.now().toDate());


        UserComment save = userCommentService.save(builder.build());
        System.out.println(save);

        List<Book> list = bookService.list();
        System.out.println(list);
    }



    @Test
    public void count() {
        long count = bookService.count();
        System.out.println(count);
    }

    @Test
    public void pageQuery() {
        Page<Book> pageQuery = bookService.pageQuery("java");
        List<Book> content = pageQuery.getContent();
        System.out.println(content);
    }
}