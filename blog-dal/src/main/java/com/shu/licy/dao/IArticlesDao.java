package com.shu.licy.dao;

import com.shu.licy.model.Articles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：文章dao接口
 * User:Lichangya
 * Date:2017/5/6.
 */
public interface IArticlesDao extends IBaseDao<Articles>{

    /**
     * 更新文章
     * @param bean
     */
    void updateArticle(@Param("bean")Articles bean);

    /**
     * 通过编号查询文章
     * @param id 编号
     * @return
     */
    Articles queryArticleByid(int id);

    /**
     * 通过标题查询文章
     * @param title 标题
     * @return
     */
    List<Articles> queryArticleByTitle(String title);

}
