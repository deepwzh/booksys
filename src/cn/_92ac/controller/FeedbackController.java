package cn._92ac.controller;

import cn._92ac.bean.Result;
import cn._92ac.pojo.Borrow;
import cn._92ac.pojo.Feedback;
import cn._92ac.service.BookService;
import cn._92ac.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-12 16:12
 **/
@Controller
public class FeedbackController {
    @Autowired
    public FeedbackService feedbackService;

    @ResponseBody
    @RequestMapping(value = "/api/feedback", method = RequestMethod.POST)
    public Result Feedback(@RequestBody Feedback feedback) {
        boolean res = feedbackService.createFeedback(feedback.getUser_id(), feedback.getContent());
        if (res) {
            return new Result(0, "反馈成功");
        } else {
            return new Result(1, "反馈失败");
        }
    }
}