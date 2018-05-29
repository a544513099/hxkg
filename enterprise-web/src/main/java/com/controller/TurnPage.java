package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-07 下午 1:18
 **/
@Controller
@RequestMapping(value = "turnPage")
public class TurnPage {

    @RequestMapping(value = "trunLeft")
    public String turnLeft(HttpSession session, Model model){

        return "main/left";
    }
    @RequestMapping(value = "trunTop")
    public String turnTop(HttpSession httpSession,Model model) {
        User user = (User) httpSession.getAttribute("loginUser");
        model.addAttribute("realName", user.getRealName());
        return "main/top";
    }
}
