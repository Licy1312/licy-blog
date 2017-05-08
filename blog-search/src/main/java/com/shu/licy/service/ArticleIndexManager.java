package com.shu.licy.service;

import com.shu.licy.IndexManager;
import com.shu.licy.exception.AnalyzerExceptionEnum;
import com.shu.licy.exception.DocumentAnalyzerException;
import com.shu.licy.manager.ArticleManager;
import com.shu.licy.model.ArticleBO;
import com.shu.licy.utils.FilePathDealUtils;
import com.shu.licy.utils.FilesToString;
import com.shu.licy.utils.IndexResult;
import com.shu.licy.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apdplat.word.lucene.ChineseWordAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description：索引管理
 * User:Lichangya
 * Date:2017/5/8.
 */
@Slf4j
@Component
public class ArticleIndexManager implements IndexManager {
    /**
     * 分词路径管理
     */
    private static Directory directory;

    /**
     * 分词器
     */
    private static Analyzer analyzer;

    /**
     * 索引配置
     */
    private static IndexWriterConfig indexWriterConfig;

    /**
     * 索引写组件
     */
    private static IndexWriter indexWriter;

    /**
     * 索引读控制器
     */
    private static DirectoryReader directoryReader;

    /**
     * 搜索器
     */
    private static IndexSearcher indexSearcher;

    /**
     * 文件路径配置
     */
    @Autowired
    private FilePathDealUtils filePathDealUtils;

    /**
     * 文章控制
     */
    @Autowired
    private ArticleManager articleManager;

    /**
     * 初始化写索引条件
     */
    public void initWrite(){
        try {
            //初始化
            directory = FSDirectory.open(Paths.get(filePathDealUtils.getIndexPath()));
            analyzer = new ChineseWordAnalyzer("BidirectionalMaximumMatching");
            indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
        } catch (Exception e) {
            log.error("初始化写索引条件是遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.INDEX_CREATE_INIT_ERROR);
        }
    }

    /**
     * 初始化查索引条件
     */
    public void initSearch(){
        try {
            directory = FSDirectory.open(Paths.get(filePathDealUtils.getIndexPath()));
            directoryReader = DirectoryReader.open(directory);
            indexSearcher = new IndexSearcher(directoryReader);
            analyzer = new ChineseWordAnalyzer("BidirectionalMaximumMatching");
        } catch (Exception e) {
            log.error("初始化查询索引条件是遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.INDEX_SEARCH_INIT_ERROR);
        }
    }
    /**
     * 关闭索引相关的流
     */
    public void close(){
        try {
            indexWriter.close();
            directory.close();
        } catch (IOException e) {
            log.error("关闭索引流的时候遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.INDEX_WRITE_CLOSE_ERROR);
        }
    }

    /**
     * 创建索引
     */
    @Override
    public void createIndex(){
        try {
            Date start = new Date();
            //初始化
            this.initWrite();
            List<ArticleBO> articleBOList  = articleManager.getAllArticle();
            for(ArticleBO articleBO:articleBOList){
                //写入索引
                indexWriter.addDocument(getDocument(articleBO));
            }
            Date end = new Date();
            log.info("索引创建完成一共耗时:{}，处理的文章数量:{}", TimeUtils.timeDistance(start,end),articleBOList.size());
        } catch (Exception e) {
            log.error("创建索引遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.INDEX_WRITE_ERROR);
        }finally {
            //关闭流
            this.close();
        }
    }

    /**
     * 删除索引
     */
    @Override
    public void deleteAllIndex() {
        //更加编号精确定位索引
        this.initWrite();
        try {
            indexWriter.deleteAll();
        } catch (Exception e) {
            log.error("更新索引遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.DELETE_INDEX_ERROR);
        }finally {
            //关闭流
            this.close();
        }
    }

    @Override
    public void rebuildIndex() {
        File file =new File("D:\\data\\test");
        //1.备份索引文件

        //2.清空索引文件

        //3.重新构建索引文件

        //4.若失败进行回滚
    }

    /**
     * 添加新的索引到索引库
     * @param articleBO
     */
    @Override
    public void addFileIndex(ArticleBO articleBO) {
        //更加编号精确定位索引
        this.initWrite();
        try {
            indexWriter.addDocument(getDocument(articleBO));
        } catch (Exception e) {
            log.error("更新索引遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.UPDATE_INDEX_ERROR);
        }finally {
            //关闭流
            this.close();
        }
    }

    /**
     * 更新索引
     * @param articleBO
     */
    @Override
    public void updateFileIndex(ArticleBO articleBO) {
        //更加编号精确定位索引
        this.initWrite();
        try {
            indexWriter.updateDocument(new Term("id",Integer.toString(articleBO.getId())),getDocument(articleBO));
        } catch (Exception e) {
            log.error("更新索引遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.UPDATE_INDEX_ERROR);
        }finally {
            //关闭流
            this.close();
        }
    }

    /**
     * 通过编号删除索引
     * @param number
     */
    @Override
    public void deleteIndexById(String number) {
        //初始化
        this.initWrite();
        try {
            indexWriter.deleteDocuments(new Term("id",number));
        } catch (Exception e) {
            log.error("删除索引时遇到错误:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.DELETE_INDEX_ERROR);
        }finally {
            //关闭流
            this.close();
        }
    }

    /**
     * 搜索索引
     * @param kayWords 搜索词
     */
    public List<IndexResult<String>> searchIndex(String kayWords){
        List<IndexResult<String>> indexResultList = new ArrayList<IndexResult<String>>();
        try {

            //要查询的域
            String fields[] = {"title","content"};
            MultiFieldQueryParser  multiFieldQueryParser = new MultiFieldQueryParser(fields,analyzer);
            Query query = multiFieldQueryParser.parse(kayWords);
            Date start = new Date();
            TopDocs topDocs = indexSearcher.search(query,100);
            Date end = new Date();
            log.info("对索引的检索一共耗时:{}", TimeUtils.timeDistance(start,end));
            for(ScoreDoc sd: topDocs.scoreDocs) {
                IndexResult<String>  indexResult= new IndexResult<String>();
                Document doc = indexSearcher.doc(sd.doc);
                String title = doc.get("name");
                indexResult.setResult(title);
                indexResultList.add(indexResult);
            }
        } catch (Exception e) {
            log.error("索引检索过程中出现异常:{}",e);
            throw new DocumentAnalyzerException(AnalyzerExceptionEnum.INDEX_SEARCH_ERROR);
        }
        return indexResultList;
    }

    /**
     * 组装Document
     * @param articleBO
     * @return
     */
    public Document getDocument(ArticleBO articleBO){
        Document doc = new Document();
        doc.add(new Field("id", Integer.toString(articleBO.getId()),TextField.TYPE_STORED));
        doc.add(new Field("name",articleBO.getTitle(), TextField.TYPE_STORED));
        doc.add(new Field("content", articleBO.getContent(), TextField.TYPE_STORED));
        return doc;
    }
}
