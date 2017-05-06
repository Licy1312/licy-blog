package com.shu.licy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Accounts extends Base{

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态：启用（1）,禁用（0），默认为1
     */
    private int status;

}
