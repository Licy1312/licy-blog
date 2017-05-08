package com.shu.licy.utils;

import com.shu.licy.model.ArticleBO;
import com.shu.licy.model.Articles;

/**
 * Description： 数据对象转业务对象
 * User:Lichangya
 * Date:2017/5/8.
 */
public class TransferDOToBO {

    public static ArticleBO articleToArticleBO(Articles articles) {
        if (articles == null) {
            return null;
        }
        ArticleBO articleBO = new ArticleBO();
        articleBO.setType(articles.getType());
        articleBO.setTitle(articles.getTitle());
        articleBO.setDocAbstract(articles.getDocAbstract());
        articleBO.setKeywords(articles.getKeywords());
        articleBO.setTopics(articles.getTopics());
        articleBO.setContent(articles.getContent());
        articleBO.setUrlPath(articles.getUrlPath());
        articleBO.setNoteId(articles.getNoteId());
        articleBO.setHits(articles.getHits());
        articleBO.setId(articles.getId());
        articleBO.setCreateBy(articles.getCreateBy());
        articleBO.setCreateTime(articles.getCreateTime());
        articleBO.setUpdateBy(articles.getUpdateBy());
        articleBO.setUpdateTime(articles.getUpdateTime());
        return articleBO;
    }
}
