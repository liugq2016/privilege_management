package cn.lgq.www.service;

import cn.lgq.www.domain.Permission;
import cn.lgq.www.domain.Role;

import java.util.List;

/**
 * role表的service层接口
 */
public interface RoleService {

    /**
     * 查询所有角色信息
     * @return
     */
    public List<Role> findAll();

    /**
     * 创建角色信息
     * @param role
     */
    public void saveRole(Role role);

    /**
     * 通过id查找role信息
     * @param roleid
     * @return
     */
    public Role findById(String roleid);

    /**
     * 通过roleid查找可以添加的权限
     * @param roleid
     * @return
     */
    public List<Permission> findOtherPermissions(String roleid);

    /**
     * 向role_permission表添加数据,向role中添加权限
     * @param roleid
     * @param permissionids
     */
    public void addPermissionToRole(String roleid,String[] permissionids);

}
