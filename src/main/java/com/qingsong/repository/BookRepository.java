package com.qingsong.repository;

import com.qingsong.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-29 14:37
 * @Version 1.0
 */

public interface BookRepository extends ElasticsearchRepository<Book,String> {
}
