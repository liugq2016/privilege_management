package cn.lgq.www.service;

import cn.lgq.www.domain.SysLog;

import java.util.List;

/**
 * 日志信息表(syslog)的service层接口
 */
public interface SysLogService {

    /**
     * 插入数据
     * @param syslog
     */
    public void save(SysLog syslog);

    /**
     * 查询表中所有数据
     * @return
     */
    public List<SysLog> findAll();
}
