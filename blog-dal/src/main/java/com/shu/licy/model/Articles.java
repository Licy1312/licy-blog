package com.shu.licy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Description：文章数据对象
 * Created by Administrator on 2016/5/1 0001.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Articles extends Base{

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
