package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Users extends Base{

    /**
     * 账户号
     */
    private int accountId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 等级
     */
    private int grade;

    /**
     * 自我介绍
     */
    private String introduce;

    /**
     * 头像路径
     */
    private String headAppear;
}
