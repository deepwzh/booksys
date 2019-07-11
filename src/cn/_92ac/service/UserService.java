package cn._92ac.service;

import cn._92ac.mapper.BookMapper;
import cn._92ac.mapper.UserMapper;
import cn._92ac.pojo.Book;
import cn._92ac.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-11 11:29
 **/

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public boolean check_user(String username, String password){
        User user = userMapper.selectUserByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return true;
        }else {
            return false;
        }
    }
    public User getUserByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        return user;
    }


}
