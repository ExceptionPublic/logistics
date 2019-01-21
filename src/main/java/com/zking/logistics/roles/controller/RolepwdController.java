package com.zking.logistics.roles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles/rolepwd")
public class RolepwdController {
    /**
     * 跳转至查询界面
     * @return
     */
    @RequestMapping("/toRolepwd")
    public String toRolepwd(){
        return "/roles/rolepwd/Rolepwd";
    }
    /**
     * 跳转至修改密码
     * @return
     */
    @RequestMapping("/RolepwdEdit")
    public String RolepwdEdit(){
        return "/roles/rolepwd/RolepwdEdit";
    }
}
