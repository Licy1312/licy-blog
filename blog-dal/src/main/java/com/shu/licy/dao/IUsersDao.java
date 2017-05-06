package com.shu.licy.dao;

import com.shu.licy.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：用户dao接口
 * User:Lichangya
 * Date:2017/5/6.
 */
public interface IUsersDao {

    /**
     * 添加用户
     * @param bean
     */
    void addUser(@Param("bean")Users bean);

    /**
     * 修改用户信息
     * @param bean
     */
    void updateUser(@Param("bean")Users bean);

    /**
     * 通过账户号查询
     * @param id 账户号
     * @return
     */
    Users queryUserById(int id);

    /**
     * 查询所有用户
     * @return
     */
    List<Users> queryUserList();
}
