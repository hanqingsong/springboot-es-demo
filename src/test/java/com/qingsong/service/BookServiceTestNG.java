package com.qingsong.service;


import com.qingsong.SpringbootEsDemoApplicationTests;
import com.qingsong.entity.Book;
import com.qingsong.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-29 18:04
 * @Version 1.0
 */
public class BookServiceTestNG extends SpringbootEsDemoApplicationTests {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;

    @BeforeEach
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() {
        List<Book> list = null;
        Iterable<Book> all = bookRepository.findAll();
        List<Book> list1 = bookService.list();
        Assert.assertNotNull(list1);
    }


    @Test
    public void testPrint(){
        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("hello mock");

        String result = list.get(0);

        //验证方法调用(是否调用了get(0))
        verify(list).get(0);

        //测试
        Assert.assertEquals("hello mock", result);
    }

    @org.testng.annotations.Test
    public void testCount() {
    }

    @org.testng.annotations.Test
    public void testSave() {
    }

    @org.testng.annotations.Test
    public void testPageQuery() {
    }
}