package cn._92ac.bean;

import java.sql.Date;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-12 19:07
 **/
public class FeedbackInfo {
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    private String content;
    private Date create_time;
}
