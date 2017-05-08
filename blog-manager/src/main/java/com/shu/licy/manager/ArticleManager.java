package com.shu.licy.manager;

import com.shu.licy.dao.IArticlesDao;
import com.shu.licy.model.ArticleBO;
import com.shu.licy.model.Articles;
import com.shu.licy.utils.TransferDOToBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：文章管理
 * User:Lichangya
 * Date:2017/5/8.
 */
@Component
public class ArticleManager {

    @Autowired
    private IArticlesDao articlesDao;

    /**
     * 获取所有的文章
     * @return
     */
    public List<ArticleBO> getAllArticle(){

        List<ArticleBO> articleBOList = new ArrayList<ArticleBO>();
        List<Articles> articlesList = articlesDao.queryAllArticle();
        if(articlesList == null ||articlesList.size() == 0){
            return null;
        }
        for(Articles articles : articlesList){
            articleBOList.add(TransferDOToBO.articleToArticleBO(articles));
        }
        return articleBOList;
    }
}
