package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

//@RestController 只能返回String、Object、Json等实体对象，不能跳转到模版页面。
// @Controller 跳转到模版页面。
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        if(StringUtils.hasText(username) && "123456".equals(password)){
            // 登录成功
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        }

        model.addAttribute("msg", "用户名或密码错误");
        return "index";
    }
}

