package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Description：基础业务对象
 * User:Lichangya
 * Date:2017/5/8.
 */
@Getter
@Setter
@ToString
public class BaseBO {
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
