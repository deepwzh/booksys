package cn._92ac.mapper;

import cn._92ac.bean.FeedbackInfo;
import cn._92ac.pojo.Feedback;

import java.sql.Date;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-12 16:17
 **/
public interface FeedbackMapper {
    public boolean addFeedback(Feedback feedback);
}
