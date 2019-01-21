package com.zking.logistics.roles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/roles/roleauthority")
@Controller
public class RoleAuthorityController {

    @RequestMapping("/toRoleAuthority")
    public String toRoleAuthority(){
        return "/roles/roleauthority/RoleAuthority";
    }
}
