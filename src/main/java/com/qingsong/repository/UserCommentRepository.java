package com.qingsong.repository;

import com.qingsong.entity.Book;
import com.qingsong.entity.UserComment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-29 14:37
 * @Version 1.0
 */
@Repository
public interface UserCommentRepository extends ElasticsearchRepository<UserComment,Integer> {
}
