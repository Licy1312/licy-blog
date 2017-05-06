package com.shu.licy.dao;

import com.shu.licy.model.Accounts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：账户dao接口
 * User:Lichangya
 * Date:2017/5/6.
 */
public interface IAccountsDao {

    /**
     * 添加账户
     * @param bean
     */
    void addAccount(@Param("bean")Accounts bean);

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Accounts queryLogin(@Param("username")String username,@Param("password")String password);


    /**
     * 通过账户号查询
     * @param id 账户号
     * @return
     */
    Accounts queryById(int id);

    /**
     * 修改账户密码或用户名、状态等
     * @param bean
     */
    void updateAccount(@Param("bean")Accounts bean);

    /**
     * 查询所有账户
     * @return
     */
    List<Accounts> queryAccountList();
}
