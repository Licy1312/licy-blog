package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Description：实体类的基类
 * User:Lichangya
 * Date:2017/5/5.
 */
@Getter
@Setter
@ToString
public class Base {

    /**
     * 对象唯一标识
     */
    private int id;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
}
