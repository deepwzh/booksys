package cn._92ac.service;

import cn._92ac.mapper.BookMapper;
import cn._92ac.mapper.FeedbackMapper;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.Borrow;
import cn._92ac.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-12 16:30
 **/

@Service
public class FeedbackService {
    @Autowired
    public FeedbackMapper feedbackMapper;

    public boolean createFeedback(int user_id, String content){
        Feedback feedback = new Feedback();
        feedback.setContent(content);
        feedback.setCreate_time(new Date(System.currentTimeMillis()));
        feedback.setUser_id(user_id);
        boolean res = feedbackMapper.addFeedback(feedback);
        return res;
    }
}
