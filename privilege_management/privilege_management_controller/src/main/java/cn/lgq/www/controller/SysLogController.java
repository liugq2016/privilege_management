package cn.lgq.www.controller;

import cn.lgq.www.domain.SysLog;
import cn.lgq.www.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("syslogcontroller")
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService syslogservice = null;

    @RequestMapping("/findall")
    public ModelAndView findAll(){
        ModelAndView modelandview = new ModelAndView();
        List<SysLog> logs = syslogservice.findAll();
        modelandview.addObject("logs",logs);
        modelandview.setViewName("syslog-list");
        return modelandview;
    }
}
