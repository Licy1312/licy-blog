package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description：文章业务对象
 * User:Lichangya
 * Date:2017/5/8.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ArticleBO extends BaseBO {

    /**
     * 文章类型 0：自创，1：修改，2：复制
     */
    private int type;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String docAbstract;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 主题
     */
    private String topics;

    /**
     * 内容
     */
    private String content;

    /**
     * 来源
     */
    private String urlPath;

    /**
     *笔记本编号
     */
    private int noteId;

    /**
     * 点击量
     */
    private int hits;

}
