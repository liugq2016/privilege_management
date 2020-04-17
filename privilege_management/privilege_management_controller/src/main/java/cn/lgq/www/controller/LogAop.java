package cn.lgq.www.controller;

import cn.lgq.www.domain.SysLog;
import cn.lgq.www.service.SysLogService;
import cn.lgq.www.utils.UUIDUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 利用aop记录操作日志
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService syslogservice = null;

    private Date visitime;//开始时间
    private Class clazz;//访问的类
    private Method method;//执行的方法

    /**
     * 前置通知,用来获取开始时间，执行的类和方法
     * @param joinpoint
     */
    @Before("execution(* cn.lgq.www.controller.*.*(..))")
    public void doBefore(JoinPoint joinpoint) throws NoSuchMethodException {
        visitime = new Date();//开始时间
        clazz = joinpoint.getTarget().getClass();//访问的类
        String methodname = joinpoint.getSignature().getName();//获取访问方法的名称
        Object[] args = joinpoint.getArgs();//获取访问方法的参数
//        获取具体执行方法的method对象
        if (args == null || args.length == 0){
//            无参方法
            method = clazz.getMethod(methodname);

        }else {
//            有参方法
            Class[] methodargs = new Class[args.length];

            for (int i = 0; i < args.length;++i){
                    methodargs[i] = args[i].getClass();
            }

            method = clazz.getMethod(methodname,methodargs);
        }

    }

    /**
     * 后置通知
     * @param joinpoint
     */
    @After("execution(* cn.lgq.www.controller.*.*(..))")
    public void doAfter(JoinPoint joinpoint){
        Long time = new Date().getTime() - visitime.getTime();//获取访问时长
        String url = null;

//        获取url
        if (clazz != null && method != null && clazz != LogAop.class){
//            获取类上@RequestMapping("/findAll")中的/findAll
            RequestMapping classrequestmapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classrequestmapping != null){
                String[] classvalue = classrequestmapping.value();
                RequestMapping methodrequestmapping = method.getAnnotation(RequestMapping.class);
                if (methodrequestmapping != null){
                    String[] methodvalue = methodrequestmapping.value();
                    url = classvalue[0]+methodvalue[0];
                }
            }
        }


//        获取访问的ip地址
        String ip = request.getRemoteAddr();
//        获取当前操作的用户
        SecurityContext securitycontext = SecurityContextHolder.getContext();//从上下文获取当前登录的用户
        User user = (User) securitycontext.getAuthentication().getPrincipal();
        String username = user.getUsername();
//        向SysLog对象封装日志信息
        SysLog sysLog = new SysLog();
        sysLog.setId(UUIDUtils.getUuid());
        sysLog.setExecutiontime(time);//执行时长
        sysLog.setIp(ip);//访问者的ip
        sysLog.setMethod("[类名]" + clazz.getName()+"[方法名]"+method.getName());
        sysLog.setUrl(url);//访问的url
        sysLog.setUsername(username);//访问者的姓名
        sysLog.setVisitime(visitime);//访问开始时间


// 完成日志的数据库操作
        syslogservice.save(sysLog);
    }

}
