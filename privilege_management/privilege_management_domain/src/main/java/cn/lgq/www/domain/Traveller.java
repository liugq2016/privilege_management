package cn.lgq.www.domain;

/**
 * traveller表的实体类,游客表
 */
public class Traveller {

    private String id;
    private String name;
    private String sex;
    private String phonenum;
    private Integer credentialstype;//身份证类型 0身份证 1护照 2军官
    private String credentialstypestr;
    private String  credentialsnum;
    private Integer travellertype;//旅客类型：0 成人 1 儿童
    private String travellertypestr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getCredentialstype() {
        return credentialstype;
    }

    public void setCredentialstype(Integer credentialstype) {
        this.credentialstype = credentialstype;
    }

    public String getCredentialsnum() {
        return credentialsnum;
    }

    public void setCredentialsnum(String credentialsnum) {
        this.credentialsnum = credentialsnum;
    }

    public Integer getTravellertype() {
        return travellertype;
    }

    public void setTravellertype(Integer travellertype) {
        this.travellertype = travellertype;
    }

    public String getCredentialstypestr() {
        if(credentialstype != null){
            if (credentialstype == 0)
                credentialstypestr = "身份证";
            if (credentialstype == 1)
                credentialstypestr = "护照";
            if (credentialstype == 2)
                credentialstypestr = "军官证";
        }

        return credentialstypestr;
    }

    public void setCredentialstypestr(String credentialstypestr) {
        this.credentialstypestr = credentialstypestr;
    }

    public String getTravellertypestr() {
        if (travellertype != null){
            if (travellertype == 0)
                travellertypestr = "成人";
            if (travellertype == 1)
                travellertypestr = "儿童";
        }
        return travellertypestr;
    }

    public void setTravellertypestr(String travellertypestr) {
        this.travellertypestr = travellertypestr;
    }


    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", credentialstype=" + credentialstype +
                ", credentialstypestr='" + credentialstypestr + '\'' +
                ", credentialsnum='" + credentialsnum + '\'' +
                ", travellertype=" + travellertype +
                ", travellertypestr='" + travellertypestr + '\'' +
                '}';
    }



}
