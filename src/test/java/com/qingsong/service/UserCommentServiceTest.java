package com.qingsong.service;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.qingsong.SpringbootEsDemoApplicationTests;
import com.qingsong.entity.UserComment;
import org.assertj.core.util.Lists;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-03-15 14:02
 */
public class UserCommentServiceTest extends SpringbootEsDemoApplicationTests {
    @Autowired
    private UserCommentService userCommentService;

    public void testCount() {
    }

    //     private Long .commentId();
//     private Long .themeId();
//     private Long .userId();
//     private Integer .type();
//     private Integer .status();
//     private String .content();
//     private Date .createTime();
//     private Date .updateTime();
    @Test
    @Rollback(value = false)
    public void testSave() {
        List<Integer> typeList = Lists.newArrayList(1, 2);
        List<Integer> statusList = Lists.newArrayList(0, 1, 2);

        // 1w文章
        for (long i = 0; i < 110; i++) {
            // 3wu
            for (long j = 0; j < 10; j++) {
                UserComment.UserCommentBuilder builder = UserComment.builder()
                        .themeId(i)
                        .commentId(i * 100 + j)
                        .userId(j * RandomUtil.randomInt(1, 3))
                        .type(RandomUtil.randomInt(1, 2))
                        .status(RandomUtil.randomInt(0, 2))
                        .content("内容 " + i + " 评论者：" + j)
                        .createTime(DateTime.now().toDate())
                        .updateTime(DateTime.now().toDate());
                UserComment save = userCommentService.save(builder.build());
                System.out.println("内容 " + i + " 评论者：" + j + "--" + save);
                // try {
                //     // Thread.sleep(1);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        }
        System.out.println("sddddddddddd");
    }
}