package com.shu.licy.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description：
 * User:Lichangya
 * Date:2017/4/27.
 */
@Getter
@Setter
@ToString
public class IndexResult<T> {
    /**
     * 编号
     */
    private int id;

    /**
     * 对象
     */
    private T result;
}
