package cn.lgq.www.service.impl;

import cn.lgq.www.dao.RoleDao;
import cn.lgq.www.domain.Permission;
import cn.lgq.www.domain.Role;
import cn.lgq.www.service.RoleService;
import cn.lgq.www.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * role表的service层实现类
 */
@Service("roleservice")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roledao = null;

    /**
     * 查询所有角色信息
     * @return
     */
    @Override
    public List<Role> findAll() {
        List<Role> roles = null;
        try {
            roles = roledao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void saveRole(Role role) {
        String uuid = UUIDUtils.getUuid();
        role.setId(uuid);
        roledao.saveRole(role);
    }

    @Override
    public Role findById(String roleid) {
        Role role = null;
        try {
            role = roledao.findById(roleid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Permission> findOtherPermissions(String roleid) {
        List<Permission> permissions = null;
        try {
            permissions = roledao.findOtherPermissions(roleid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissions;
    }

    @Override
    public void addPermissionToRole(String roleid, String[] permissionids) {
        for (String permissionid : permissionids){
//            System.out.println("==================================================");
//            System.out.println();
//            System.out.println(roleid);
//            System.out.println(permissionid);
//            System.out.println("================================================");
            roledao.addPermissionToRole(roleid,permissionid);
        }
    }
}
