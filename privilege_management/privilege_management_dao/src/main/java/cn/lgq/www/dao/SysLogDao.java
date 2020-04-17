package cn.lgq.www.dao;

import cn.lgq.www.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("syslogdao")
public interface SysLogDao {

    @Insert("insert into syslog(id,visitime,username,ip,url,executiontime,method) " +
            "values(#{id},#{visitime},#{username},#{ip},#{url},#{executiontime},#{method})")
    public void save(SysLog syslog);

    @Select("select * from syslog ")
    public List<SysLog> findAll();
}
