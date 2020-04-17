package cn.lgq.www.service;

import cn.lgq.www.domain.Permission;

import java.util.List;

/**
 * permission表的service接口
 */
public interface PermissionService {

    public List<Permission> findAll();

    public void save(Permission permission);

}
