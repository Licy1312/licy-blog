package com.shu.licy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Description：评论编号
 * Created by Lingling on 2016/11/15.
 */
@Getter
@Setter
@ToString
public class Comment {
    /**
     * 评论者的IP
     */
    private String hostname;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件评论编号
     */
    private int pId;

    /**
     * 文章编号
     */
    private int articleId;
}
