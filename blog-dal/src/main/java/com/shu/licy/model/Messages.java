package com.shu.licy.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Description：留言数据对象
 * Created by Administrator on 2016/4/30 0030.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Messages extends Base {

    /**
     * 标题
     */
    private String title;

    /**
     * 留言者
     */
    private String author;

    /**
     * 内容
     */
    private String content;

    /**
     * 父级留言
     */
    private int pid;

    /**
     * 类型（1，公开,0私密）
     */
    private int type;


}
