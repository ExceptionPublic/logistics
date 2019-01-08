package com.zking.logistics.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/index/index.shtml")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/loginOut")
    public String toLoginOut(HttpSession session){
        session.invalidate();
        return "redirect:index/index.shtml";
    }

}
