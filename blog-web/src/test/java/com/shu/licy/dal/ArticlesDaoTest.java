package com.shu.licy.dal;

import com.shu.licy.BaseTest;
import com.shu.licy.dao.IArticlesDao;
import com.shu.licy.model.Articles;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description：
 * User:Lichangya
 * Date:2017/5/6.
 */
@Slf4j
public class ArticlesDaoTest extends BaseTest {

    @Autowired
    private IArticlesDao articlesDao;

    @Test
    public void queryListPageTest(){
        Articles article = new Articles();
        List<Articles> articlesList = articlesDao.queryListByPage(article,0,5);
        log.info("分页查询结果:{}",articlesList);
    }

    @Test
    public void queryAllArticleTest(){
        List<Articles> list = articlesDao.queryAllArticle();
        log.info("所有文章:{}",list);
    }
}
