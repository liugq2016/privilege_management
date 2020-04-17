package cn.lgq.www.controller;

import cn.lgq.www.domain.Permission;
import cn.lgq.www.domain.Role;
import cn.lgq.www.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("rolecontroller")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleservice = null;

    @RequestMapping("/findall")
    public ModelAndView findAll(){
        ModelAndView modelandview = new ModelAndView();
        List<Role> roles = roleservice.findAll();
        modelandview.addObject("roles",roles);
        modelandview.setViewName("role-list");
        return modelandview;

    }

    @RequestMapping("/save")
    public String saveRole(Role role){
        roleservice.saveRole(role);
        return "redirect:findall";
    }


    /**
     * 通过roleid查询角色信息及可以添加的权限信息
     * @param roleid
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id" , required = true) String roleid){
        ModelAndView modelandview = new ModelAndView();
        Role role = roleservice.findById(roleid);
        List<Permission> permissions = roleservice.findOtherPermissions(roleid);
        modelandview.addObject("role",role);
        modelandview.addObject("permissions",permissions);
        modelandview.setViewName("role-permission-add");
        return modelandview;
    }


    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId" , required = true) String roleid,@RequestParam(name = "ids",required = true) String[] permissionids){
       roleservice.addPermissionToRole(roleid,permissionids);
        return "redirect:findall";
    }




}
