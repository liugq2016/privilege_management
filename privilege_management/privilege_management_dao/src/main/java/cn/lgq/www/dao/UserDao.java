package cn.lgq.www.dao;

import cn.lgq.www.domain.Role;
import cn.lgq.www.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user表的dao接口
 */
@Repository("userdao")
public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(property = "roles" , column = "id",javaType = java.util.List.class, many = @Many(select = "cn.lgq.www.dao.RoleDao.findRolesByUserId" ))
    })
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(id,email,username,password,phonenum,status) values(#{id},#{email},#{username},#{password},#{phonenum},#{status})")
    public void saveUser(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roles" , column = "id",javaType = java.util.List.class, many = @Many(select = "cn.lgq.www.dao.RoleDao.findRolesByUserId"))
    })
    public UserInfo findById(String id);

    @Select("select * from role where id not in (select roleid from users_role where userid = #{uid})")
    public List<Role> findOtherRole(String uid);

    @Insert("insert into users_role(userid,roleid) values(#{uid},#{roleid})")
    public void addRoleToUser(@Param("uid") String uid,@Param("roleid") String roleid);

}
