package cn.lgq.www.service.impl;

import cn.lgq.www.dao.OrdersDao;
import cn.lgq.www.domain.Orders;
import cn.lgq.www.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersservice")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersdao = null;

    /**
     * 查询所有商品信息
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAll(int page ,int size) {
        List<Orders> orders = null;
        try {
            PageHelper.startPage(page,size);
            orders = ordersdao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 查询商品详情页
     * @param orderid
     * @return
     */
    @Override
    public Orders findById(String orderid) {
        Orders orders = null;
        try {
            orders = ordersdao.findById(orderid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
