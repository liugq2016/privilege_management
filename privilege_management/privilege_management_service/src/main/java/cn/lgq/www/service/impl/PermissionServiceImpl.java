package cn.lgq.www.service.impl;

import cn.lgq.www.dao.PermissionDao;
import cn.lgq.www.domain.Permission;
import cn.lgq.www.service.PermissionService;
import cn.lgq.www.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * permission表的service实现类
 */
@Service("permissionservice")
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissiondao = null;

    @Override
    public List<Permission> findAll() {
        List<Permission> permissions = null;
        try {
            permissions = permissiondao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissions;
    }

    @Override
    public void save(Permission permission) {
        String uuid = UUIDUtils.getUuid();
        permission.setId(uuid);
        permissiondao.save(permission);

    }
}
