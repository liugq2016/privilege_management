package cn.lgq.www.service;

import cn.lgq.www.domain.Product;

import java.util.List;

/**
 * product的服务层接口
 */
public interface ProductService {

    /**
     * 查询所有商品信息
     * @return
     */
    public List<Product> findAll(int page,int size);

    /**
     * 保存产品信息
     * @param product
     */
    public void  save(Product product);

}
