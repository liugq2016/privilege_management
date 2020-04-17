package cn.lgq.www.controller;

import cn.lgq.www.domain.Product;
import cn.lgq.www.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * product的视图层
 */
@Controller("prodectcontroller")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productservice = null;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page" ,defaultValue = "1")Integer page,@RequestParam(name = "size", defaultValue = "4")Integer size){
        ModelAndView mav = new ModelAndView();
        List<Product> products = productservice.findAll(page,size);
        PageInfo pageinfo = new PageInfo(products);
        mav.addObject("pageinfo",pageinfo);
        mav.setViewName("product-list");
        return mav;
    }

    @RequestMapping("/saveproduct")
    public String saveProduct(Product product){
        productservice.save(product);
        return "redirect:findAll";
    }
}
