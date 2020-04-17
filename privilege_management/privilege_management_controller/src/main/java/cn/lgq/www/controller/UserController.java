package cn.lgq.www.controller;

import cn.lgq.www.domain.Role;
import cn.lgq.www.domain.UserInfo;
import cn.lgq.www.service.UserService;
import cn.lgq.www.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller("usercontroller")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice = null;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelandview = new ModelAndView();
        List<UserInfo> userinfos = userservice.findAll();
        modelandview.addObject("users",userinfos);
        modelandview.setViewName("user-list");
        return modelandview;
    }


    //添加用户
    @RequestMapping("/saveuser")
    public String saveUser( UserInfo userinfo){
    userservice.saveUser(userinfo);
        return "redirect:findAll";

    }

//    查询指定id的用户信息、角色信息、权限信息
    @RequestMapping("/findbyid")
    public ModelAndView findById(String id){
        ModelAndView modelandview = new ModelAndView();
        UserInfo userinfo = userservice.findById(id);
        modelandview.addObject("user",userinfo);
        modelandview.setViewName("user-show");
        return modelandview;
    }

    /**
     * 查询给用户信息及该用户可添加的角色
     * @param uid
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id" , required = true) String uid){
        ModelAndView modelandview = new ModelAndView();
        UserInfo user = userservice.findById(uid);
        List<Role> roles = userservice.findOtherRole(uid);
        modelandview.addObject("user",user);
        modelandview.addObject("roles",roles);
        modelandview.setViewName("user-role-add");
        return modelandview;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String uid,@RequestParam(name = "ids",required = true) String[] roleids){
        userservice.addRoleToUser(uid,roleids);
        return "redirect:findAll";
    }


}
