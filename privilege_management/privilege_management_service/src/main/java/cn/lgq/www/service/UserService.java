package cn.lgq.www.service;


import cn.lgq.www.domain.Role;
import cn.lgq.www.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * user表的service接口
 */
public interface UserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     */
    public List<UserInfo> findAll();

    /**
     * 向user表中添加用户
     * @param userInfo
     */
    public void saveUser(UserInfo userInfo);

    /**
     * 查询指定id的用户信息
     * @param id
     * @return
     */
    public UserInfo findById(String id);

    /**
     * 查询指定id下可被添加的角色
     * @param uid
     * @return
     */
    public List<Role> findOtherRole(String uid);

    /**
     * 向指定用户添加角色
     * @param uid
     * @param roleids
     */
    public void addRoleToUser(String uid,String[] roleids);

}
