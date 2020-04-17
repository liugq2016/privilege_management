package cn.lgq.www.controller;

import cn.lgq.www.domain.Permission;
import cn.lgq.www.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * permission表的webc层
 */
@Controller("permissioncontroller")
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionservice = null;

    @RequestMapping("/findall")
    public ModelAndView findAll(){
        ModelAndView modelandview = new ModelAndView();
        List<Permission> permissions = permissionservice.findAll();
        modelandview.addObject("permissions",permissions);
        modelandview.setViewName("permission-list");
        return modelandview;
    }

    @RequestMapping("/save")
    public String savePermission(Permission permission){
        permissionservice.save(permission);
        return "redirect:findall";
    }

}
