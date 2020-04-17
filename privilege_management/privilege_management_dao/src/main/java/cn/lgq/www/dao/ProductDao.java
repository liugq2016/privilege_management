package cn.lgq.www.dao;

import cn.lgq.www.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * product表的持久层接口
 */
@Repository("productdao")
public interface ProductDao {

    /**
     * 查询所有商品信息
     * @return
     */
    @Select("select * from product")
    @Results(id = "productmap" , value = {
            @Result(column = "DepartureTime" , property = "timestamp")
    })
    public List<Product> findAll();

    /**
     * 保存商品信息
     * @param product
     */
    @Insert("insert into product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "values(#{id},#{productnum},#{productname},#{cityname},#{timestamp},#{productprice},#{productdesc},#{productstatus})")
    public void save(Product product);

    /**
     * 根据id查找商品信息
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    @ResultMap("productmap")
    public Product findById(String id);

}
