package cn._92ac.controller;

import cn._92ac.bean.Result;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.User;
import cn._92ac.service.BookService;
import cn._92ac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-11 11:28
 **/

@Controller
public class UserController {

    @Autowired
    public UserService userService;


    @ResponseBody
    @RequestMapping(value="/api/checkuser", produces = "application/json;charset=utf-8")
    public Result checkUser(String username, String password) {
        boolean is_vaild = userService.check_user(username, password);
        System.out.println(is_vaild);
        System.out.println("Hello World");
        if (is_vaild) {
            return new Result(1);
        } else {
            return new Result(0);
        }
    }
    class UserResult extends Result{
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        private User user;

        public UserResult(int code, String result, User user) {
            super(code, result);
            this.user = user;
        }
    }
    @ResponseBody
    @RequestMapping(value="/api/login",method= RequestMethod.POST)
    public UserResult login(@RequestBody User user) {
        boolean is_vaild = userService.check_user(user.getUsername(), user.getPassword());
        System.out.println(is_vaild);
        if (is_vaild) {
            return new UserResult(0, "登录成功", userService.getUserByUsername(user.getUsername()));
        } else {
            return new UserResult(0, "登录失败", null);
        }
    }

    @ResponseBody
    @RequestMapping(value="/api/register",method= RequestMethod.POST)
    public Result register(@RequestBody User user) {
        boolean is_vaild = userService.createUser(user);
        System.out.println(is_vaild);
        if (is_vaild) {
            return new Result(0, "注册成功");
        } else {
            return new Result(1, "登录失败");
        }
    }
}
