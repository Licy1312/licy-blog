package com.shu.licy.dal;

import com.shu.licy.BaseTest;
import com.shu.licy.dao.ICommentsDao;
import com.shu.licy.dao.IMessagesDao;
import com.shu.licy.model.Comments;
import com.shu.licy.model.Messages;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Description：公共测试类
 * User:Lichangya
 * Date:2017/5/6.
 */
@Slf4j
public class CommonDaoTest extends BaseTest{

    /**
     * 评论
     */
    @Autowired
    private ICommentsDao commentsDao;

    /**
     * 留言
     */
    @Autowired
    private IMessagesDao messagesDao;

    @Test
    public void addCommentTest(){
        Comments comments = new Comments();
        comments.setArticleId(12);
        comments.setContent("很垃圾！");
        comments.setHostname("1.2.4.5");
        comments.setCreateBy("李昌亚");
        commentsDao.add(comments);
        log.info("添加评论结果:{}",comments);
    }

    @Test
    public void queryCommentTest(){
        Comments comments = new Comments();
        List<Comments> commentsList = commentsDao.queryList(comments);
        log.info("查询评论结果:{}",commentsList);
    }

    @Test
    public void deleteCommentTest(){
        Comments comments = new Comments();
        comments.setArticleId(12);
        comments.setContent("很垃圾！");
        comments.setHostname("1.2.4.5");
        comments.setCreateBy("李昌亚");
        commentsDao.delete(comments);
        log.info("删除评论结果:{}",comments);
    }

    @Test
    public void addMessage(){
        Messages messages = new Messages();
        messages.setCreateTime(new Date());
        messages.setAuthor("亚哥");
        messages.setContent("打我电话，我有事找你！");
        messagesDao.add(messages);
        log.info("添加留言结果:{}",messages);
    }

    @Test
    public void queryMessageTest(){
        Messages messages = new Messages();
        List<Messages> messagesList = messagesDao.queryList(messages);
        log.info("查询留言结果:{}",messagesList);

    }

    @Test
    public void deleteMessageTest(){
        Messages messages = new Messages();
        messages.setAuthor("亚哥");
        messages.setContent("打我电话，我有事找你！");
        messagesDao.delete(messages);
        log.info("删除评论结果:{}",messages);
    }
}
