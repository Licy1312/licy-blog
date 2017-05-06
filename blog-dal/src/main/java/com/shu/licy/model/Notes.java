package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  Description：笔记本数据对象
 * Created by Lingling on 2016/10/30.
 */
@Getter
@Setter
@ToString
public class Notes extends Base{

    /**
     * 比较本名称
     */
    private String noteName;

    /**
     * 路径
     */
    private String urlPath;

    /**
     * 数量
     */
    private int num;

}
