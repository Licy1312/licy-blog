package com.shu.licy.exception;

import lombok.Getter;

/**
 * Description：异常枚举说明
 * User:Lichangya
 * Date:2017/3/25.
 */
@Getter
public enum AnalyzerExceptionEnum {

    DOCUMENT_PARSING_ERROR("DOCUMENT_PARSING_ERROR","文档解析错误"),

    DOCUMENT_NULL_ERROR("DOCUMENT_NULL_ERROR","文档集数量为空"),

    INDEX_WRITE_ERROR("INDEX_WRITE_ERROR","文档创建索引异常"),

    INDEX_CLOSE_FLOW_ERROR("INDEX_CLOSE_FLOW_ERROR","索引写操作流关闭异常"),

    INDEX_WRITE_CLOSE_ERROR("INDEX_WRITE_CLOSE_ERROR","关闭索引写操作流异常"),

    INDEX_CONFIG_INIT_ERROR("INDEX_CONFIG_INIT_ERROR","索引配置初始化异常"),

    INDEX_SEARCH_ERROR("INDEX_SEARCH_ERROR","索引检索过程中异常"),

    ANALYZER_DOCUMENT_ERROR("ANALYZER_DOCUMENT_ERROR","文档分词异常"),

    INDEX_CREATE_INIT_ERROR("INDEX_CREATE_INIT_ERROR","创建索引时初始化条件异常"),

    INDEX_SEARCH_INIT_ERROR("INDEX_SEARCH_INIT_ERROR","查询索引时初始化条件异常"),

    DELETE_INDEX_ERROR("DELETE_INDEX_ERROR","删除索引的时候异常"),

    UPDATE_INDEX_ERROR("UPDATE_INDEX_ERROR","删除索引的时候异常"),

    SEARCH_INDEX_NULL_ERROR("SEARCH_INDEX_NULL_ERROR","索引库中不存在"),

    SEARCH_INDEX_MORE_ONE("SEARCH_INDEX_MORE_ONE","索引库匹配数量大于1");

    private String code;
    private String desc;

    AnalyzerExceptionEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static AnalyzerExceptionEnum getExceptionDesc(String code){
        for(AnalyzerExceptionEnum exceptionEnum:values()){
            if(exceptionEnum.getCode().equals(code)){
                return exceptionEnum;
            }
        }
        return null;
    }
}
