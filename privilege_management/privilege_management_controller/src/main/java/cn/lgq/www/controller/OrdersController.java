package cn.lgq.www.controller;

import cn.lgq.www.domain.Orders;
import cn.lgq.www.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("orderscontroller")
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersservice = null;

    /**
     * 未分页的findAll方法
     * @return
     */
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//        ModelAndView modelandview = new ModelAndView();
//        List<Orders> orders = ordersservice.findAll();
//        modelandview.addObject("orders",orders);
//        modelandview.setViewName("orders-list");
//        return modelandview;
//    }


    /**
     * 分页的findAll方法
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page" ,required = true ,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView modelandview = new ModelAndView();
        List<Orders> orders = ordersservice.findAll(page,size);
        PageInfo pageinfo = new PageInfo(orders);
        modelandview.addObject("pageinfo",pageinfo);
        modelandview.setViewName("orders-page-list");

        return modelandview;
    }

    /**
     * 订单详情页
     * @param orderid
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id" ,required = true) String orderid){
        ModelAndView modelandview = new ModelAndView();
        Orders orders = ordersservice.findById(orderid);
        modelandview.addObject("orders",orders);
        modelandview.setViewName("orders-show");
        return modelandview;
    }


}
