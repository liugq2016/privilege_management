package cn.lgq.www.domain;

import java.util.List;

/**
 * role(角色表)表的实体类
 */
public class Role {

    private String id;
    private String rolename;
    private String roledesc;
    private List<UserInfo> userinfos;
    private List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public List<UserInfo> getUserinfos() {
        return userinfos;
    }

    public void setUserinfos(List<UserInfo> userinfos) {
        this.userinfos = userinfos;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                ", users=" + userinfos +
                ", permissions=" + permissions +
                '}';
    }
}
