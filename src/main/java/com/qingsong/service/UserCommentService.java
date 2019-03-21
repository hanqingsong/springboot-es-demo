package com.qingsong.service;

import com.qingsong.entity.UserComment;
import com.qingsong.repository.UserCommentRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class UserCommentService {
    @Autowired
    UserCommentRepository userCommentRepository;

    /**
     * 列表
     * @return
     */
    List<UserComment> list(){
        Iterable<UserComment> userComments = userCommentRepository.findAll();
        List<UserComment> list = IteratorUtils.toList(userComments.iterator());
        return list;
    }

    /**
     * 总数
     * @return
     */
    long count(){
        long count = userCommentRepository.count();
        return count;
    }

    /**
     * 新增
     * @return
     */
    UserComment save(UserComment userComment){
        UserComment save = userCommentRepository.save(userComment);
        return save;
    }

    /**
     * 查询
     * @param kw
     * @return
     */
    public Page<UserComment> pageQuery(String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", kw))
                // .withPageable(PageRequest.of(1, 20))
                .build();
        return userCommentRepository.search(searchQuery);
    }

}
