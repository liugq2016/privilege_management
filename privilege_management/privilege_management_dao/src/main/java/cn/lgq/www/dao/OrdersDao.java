package cn.lgq.www.dao;

import cn.lgq.www.domain.Member_tab;
import cn.lgq.www.domain.Orders;
import cn.lgq.www.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository("ordersdao")
public interface OrdersDao {

    @Select("select * from orders")
    @Results(value = {
            @Result(property = "product" ,column = "productid" , javaType = Product.class,one = @One(select = "cn.lgq.www.dao.ProductDao.findById"))
    },id = "productmap")
    public List<Orders> findAll();

    @Select("select * from orders where id = #{orderid}")
    @Results(value = {
            @Result(property = "product" ,column = "productid" , javaType = Product.class,one = @One(select = "cn.lgq.www.dao.ProductDao.findById")),
            @Result(property = "member_tab",column = "memberid",javaType = Member_tab.class,one = @One(select = "cn.lgq.www.dao.Member_tabDao.findById")),
            @Result(property = "travellers",column = "id" , javaType = java.util.List.class,many = @Many(select = "cn.lgq.www.dao.TravellerDao.findManyById"))
    })
    public Orders findById(String orderid);

}
