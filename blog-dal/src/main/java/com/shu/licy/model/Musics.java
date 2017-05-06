package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 *  Description：音乐数据对象
 * Created by Administrator on 2016/5/3 0003.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Musics extends Base{
    /**
     * 音乐名称
     */
    private String name;

    /**
     * 演唱者
     */
    private String author;

    /**
     * 存储路径
     */
    private String resources;

    /**
     * 类型
     */
    private String type;

}
