package cn.lgq.www.service.impl;

import cn.lgq.www.dao.SysLogDao;
import cn.lgq.www.domain.SysLog;
import cn.lgq.www.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("syslogservice")
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao syslogdao = null;

    /**
     * 向日志信息表中添加数据
     * @param syslog
     */
    @Override
    public void save(SysLog syslog) {

        syslogdao.save(syslog);
    }

    /**
     * 查询所有日志信息
     * @return
     */
    @Override
    public List<SysLog> findAll() {
        List<SysLog> syslogs = null;
        try {
            syslogs = syslogdao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return syslogs;
    }

}
