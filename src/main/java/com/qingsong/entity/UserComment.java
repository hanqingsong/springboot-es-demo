package com.qingsong.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-03-15 13:56
 */
@Data
@Builder
@Document(indexName = "usercomment",type = "usercomment" , shards = 1, replicas = 0,  refreshInterval = "-1")
public class UserComment {
    @Id
    private Long commentId;
    private Long themeId;
    private Long userId;
    private Integer type;
    private Integer status;
    private String content;
    private Date createTime;
    private Date updateTime;
}
