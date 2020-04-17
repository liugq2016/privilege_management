package cn.lgq.www.service;

import cn.lgq.www.domain.Orders;

import java.util.List;

public interface OrdersService {

    /**
     * orders表的查询所有方法
     * @return
     */
    public List<Orders> findAll(int page,int size);

    /**
     * 查询商品详情页
     * @param orderid
     * @return
     */
    public Orders findById(String orderid);
}
