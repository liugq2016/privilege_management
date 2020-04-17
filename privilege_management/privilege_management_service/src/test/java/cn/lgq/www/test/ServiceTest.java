package cn.lgq.www.test;

import cn.lgq.www.domain.Product;
import cn.lgq.www.service.ProductService;
import cn.lgq.www.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {

    @Test
    public void findAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext_service.xml");
        ProductService service = applicationContext.getBean("productservice", ProductService.class);
        System.out.println(service);
        service.findAll(1,4);
    }

}
