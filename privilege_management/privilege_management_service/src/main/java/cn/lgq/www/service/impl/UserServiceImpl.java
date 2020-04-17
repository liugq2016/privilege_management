package cn.lgq.www.service.impl;

import cn.lgq.www.dao.UserDao;
import cn.lgq.www.domain.Role;
import cn.lgq.www.domain.UserInfo;
import cn.lgq.www.service.UserService;
import cn.lgq.www.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao = null;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        boolean flag  = false;
        try {
            UserInfo userinfo = userdao.findByUsername(username);
//        将users对象封装成userdetails对象
//            user = new User(userinfo.getUsername(),"{noop}"+userinfo.getPassword(),getAuthorities(userinfo.getRoles()));
            user = new User(userinfo.getUsername(),userinfo.getPassword(),userinfo.getStatus()==0?false:true,true,true,true,getAuthorities(userinfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * list中装入的是权限
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
        }
        return authorities;
    }


    /**
     * user表查询所有
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> users = null;
        try {
            users = userdao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 向user表添加用户
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
            String uuid = UUIDUtils.getUuid();
            userInfo.setId(uuid);
            String encode_password= bCryptPasswordEncoder.encode(userInfo.getPassword());
            userInfo.setPassword(encode_password);
            userdao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userinfo = null;
        try {
            userinfo = userdao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(userinfo.getId()+"=======================findbyid");
        return userinfo;
    }

    @Override
    public List<Role> findOtherRole(String uid) {
        List<Role> roles = null;
        try {
            roles = userdao.findOtherRole(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void addRoleToUser(String uid, String[] roleids) {
            for (String roleid:roleids ){
//                System.out.println(uid);
//                System.out.println(roleid);
                userdao.addRoleToUser(uid,roleid);
            }
    }
}
