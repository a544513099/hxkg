package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-29 上午 12:03
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "login")
    public String doLogin(HttpSession session, User user, Model model) {
        User loginUser = userService.login(user);
        if (loginUser != null) {
            session.setAttribute("loginUser",loginUser);
            return "main/mainPage";
        }else {
            model.addAttribute("message", "error");
            return "../../index";
        }
    }
}
