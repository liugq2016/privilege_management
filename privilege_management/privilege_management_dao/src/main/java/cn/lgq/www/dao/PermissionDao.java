package cn.lgq.www.dao;

import cn.lgq.www.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * service表的dao接口
 */
@Repository("permissiondao")
public interface PermissionDao {

    @Select("select * from permission where id in(select permissionid from role_permission where roleid = #{roleid})")
    public List<Permission> findById(String roleid);

    @Select("select * from permission")
    public List<Permission> findAll();

    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionname},#{url})")
    public void save(Permission permission);
}
