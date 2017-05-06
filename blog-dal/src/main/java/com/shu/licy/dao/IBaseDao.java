package com.shu.licy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Description：基类dao接口
 * User:Lichangya
 * Date:2017/5/6.
 */
public interface IBaseDao<T> {
    /**
     * 1.添加对象
     * @param bean
     */
    void add(@Param("bean")T bean);

    /**
     * 2.删除对象
     * @param bean
     */
    void delete(@Param("bean")T bean);

    /**
     * 3.条件查询
     * @param bean
     * @return
     */
    List<T> queryList(@Param("bean")T bean);

    /**
     * 4.条件查询总数量
     * @param bean
     * @return
     */
    int queryCount(@Param("bean")T bean);

    /**
     * 5.分页查询
     * @param bean
     * @return
     */
    List<T> queryListByPage(@Param("bean")T bean,
                            @Param("start")int start,
                            @Param("end")int end);
}
