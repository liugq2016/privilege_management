package cn.lgq.www.domain;

import cn.lgq.www.utils.Date_StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysLog implements Serializable {

    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date visitime;
    private String visitimestr;
    private String username;
    private String ip;
    private String url;
    private Long executiontime;
    private String method;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitime() {
        return visitime;
    }

    public void setVisitime(Date visitime) {
        this.visitime = visitime;
    }

    public String getVisitimestr() {
        if (visitime != null)
            visitimestr =  Date_StringUtils.dateToString(visitime,"YYYY-mm-dd hh:mm:ss");
        return visitimestr;
    }

    public void setVisitimestr(String visitimestr) {
        this.visitimestr = visitimestr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutiontime() {
        return executiontime;
    }

    public void setExecutiontime(Long executiontime) {
        this.executiontime = executiontime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
