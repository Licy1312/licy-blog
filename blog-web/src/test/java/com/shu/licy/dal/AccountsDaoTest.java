package com.shu.licy.dal;

import com.shu.licy.BaseTest;
import com.shu.licy.dao.IAccountsDao;
import com.shu.licy.model.Accounts;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Description：
 * User:Lichangya
 * Date:2017/5/6.
 */
@Slf4j
public class AccountsDaoTest extends BaseTest {

    /**
     * 账户DML
     */
    @Autowired
    private IAccountsDao accountsDao;

    @Test
    public void queryAccountTest(){
        Accounts account = accountsDao.queryById(1);
        log.info("查询结果为:{}",account);
    }

    @Test
    public void addAccountTest(){
        Accounts account = new Accounts();
        account.setUsername("lichangya");
        account.setPassword("lichangya520");
        account.setCreateBy("李昌亚");
        account.setCreateTime(new Date());
        accountsDao.addAccount(account);
        log.info("入库数据对象为:{}",account);
    }

    @Test
    public void updateAccountTest(){
        Accounts account = new Accounts();
        account.setId(2);
        account.setUsername("Licy");
        account.setPassword("Licy1312");
        account.setUpdateBy("李昌亚");
        accountsDao.updateAccount(account);
        log.info("更新数据对象为:{}",account);
    }
}
