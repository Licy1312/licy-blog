package com.shu.licy.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Description：
 * User:Lichangya
 * Date:2017/5/8.
 */
@Getter
@Setter
@Component
public class FilePathDealUtils {
    /**
     * 数据源路径
     */
    public  String resourcePath;

    /**
     * 分词后路径
     */
    private  String analyzedPath;

    /**
     * 索引路径
     */
    private  String indexPath;

    /**
     * 索引备份地址
     */
    private String indexBackup;
}
