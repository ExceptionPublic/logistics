package com.zking.logistics.personnel.controller;

import com.zking.logistics.personnel.model.Dep;
import com.zking.logistics.personnel.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/personnel/dep")
public class DepController {

    @Autowired
    private IDepService depService;

    @RequestMapping("/queryDep")
    @ResponseBody
    public List<Dep> queryDep(){
        return depService.queryDep();
    }

}
