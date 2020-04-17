package cn.lgq.www.dao;

import cn.lgq.www.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("travellerdao")
public interface TravellerDao {
    /**
     * 通过id查找游客信息
     * @param orderid
     * @return
     */
    @Select("SELECT * FROM traveller WHERE id  IN (SELECT travellerId FROM order_traveller WHERE orderId = #{orderid})")
    public List<Traveller> findManyById(String orderid);

}
