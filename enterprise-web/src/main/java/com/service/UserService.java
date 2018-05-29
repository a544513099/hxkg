package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-29 上午 12:04
 **/
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User login(User user) {
        User loginUser = userDao.login(user.getUsername(), user.getPassword());
        return loginUser;
    }
}
