package cn._92ac.pojo;

import java.sql.Date;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-12 16:15
 **/
public class Feedback {
    private int id;
    private int user_id;
    private String content;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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



}
