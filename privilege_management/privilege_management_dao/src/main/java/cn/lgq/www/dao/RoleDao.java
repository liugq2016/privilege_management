package cn.lgq.www.dao;

import cn.lgq.www.domain.Permission;
import cn.lgq.www.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * role表的dao接口
 */
@Repository("roledao")
public interface RoleDao {

    @Select("select * from role where id in (select roleid from users_role where userid = #{userid}) ")
    @Results({
            @Result(property = "permissions",column = "id" ,javaType = java.util.List.class , many = @Many(select = "cn.lgq.www.dao.PermissionDao.findById"))
    })
    public List<Role> findRolesByUserId(String userid);


    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{rolename},#{roledesc})")
    public void saveRole(Role role);

    @Select("select * from role where id = #{roleid}")
    @Results({
            @Result(property = "id", column = "id")
    })
    public Role findById(String roleid);

    @Select("select * from permission where id not in (select permissionid from role_permission where roleid = #{roleid}) ")
    public List<Permission> findOtherPermissions(String roleid);

    @Insert("insert into role_permission(permissionid, roleid) values(#{permissionid},#{roleid})")
    public void addPermissionToRole(@Param("roleid") String roleid,@Param("permissionid") String permissiionid);

}
