package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  Description：图片数据对象
 * Created by Administrator on 2016/5/3 0003.
 */
@Getter
@Setter
@ToString
public class Picture {

    /**
     * 名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 点击量
     */
    private int hits;

    /**
     * 类别名称
     */
    private String typeName;

    /**
     * 类别：头像("APPEAR")、相册("ALBUM")、推广("SPREAD")
     */
    private String type;
}
