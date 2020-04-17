package cn.lgq.www.service.impl;

import cn.lgq.www.dao.ProductDao;
import cn.lgq.www.domain.Product;
import cn.lgq.www.service.ProductService;
import cn.lgq.www.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productservice")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productdao = null;

    @Override
    public List<Product> findAll(int page,int size) {
        List<Product> products = null;
        try {
            PageHelper.startPage(page,size);
            products = productdao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("service:findAll()执行了");
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(UUIDUtils.getUuid());
        productdao.save(product);
    }


}
