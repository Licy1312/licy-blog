package com.shu.licy;

import com.shu.licy.model.ArticleBO;
import com.shu.licy.utils.IndexResult;

import java.util.List;

/**
 * Description：索引管理接口
 * User:Lichangya
 * Date:2017/5/8.
 */
public interface IndexManager {

    /**
     * 创建索引
     */
    void createIndex();

    /**
     * 删除索引
     */
    void deleteAllIndex();

    /**
     * 重建索引
     */
    void rebuildIndex();

    /**
     * 添加新的索引到索引库
     * @param articleBO
     */
    void addFileIndex(ArticleBO articleBO);

    /**
     * 更新索引
     * @param articleBO
     */
    void updateFileIndex(ArticleBO articleBO);

    /**
     * 通过编号删除索引
     * @param number
     */
    void deleteIndexById(String number);
    /**
     * 搜索索引
     * @param keyWords
     * @return
     */
    List<IndexResult<String>> searchIndex(String keyWords);
}
