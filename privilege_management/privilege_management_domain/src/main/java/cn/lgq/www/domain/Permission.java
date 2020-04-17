package cn.lgq.www.domain;

import java.util.List;

/**
 * 权限(permission)表的对应实体类
 */
public class Permission {

    private String id;
    private String permissionname;
    private String url;
    private List<Role> roles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionname='" + permissionname + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
