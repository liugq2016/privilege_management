package cn.lgq.www.domain;

import cn.lgq.www.utils.Date_StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * orders表的实体类,订单表
 */
public class Orders implements Serializable {

    private String id;
    private String  ordernum;
    private Date ordertime;
    private String ordertimestr;
    private Integer peoplecount;
    private String orderdesc;
    private Integer paytype;
    private String paytypestr;
    private Integer orderstatus;
    private String orderstatusstr;
    private  String productid;
    private String  memberid;
    private Product product;
    private List<Traveller> travellers;
    private Member_tab member_tab;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getOrderdesc() {
        return orderdesc;
    }

    public void setOrderdesc(String orderdesc) {
        this.orderdesc = orderdesc;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getOrdertimestr() {
        if (this.ordertime != null){
           this.ordertimestr = Date_StringUtils.dateToString(ordertime,"yyyy-mm-dd hh:mm");
        }
        return ordertimestr;
    }

    public void setOrdertimestr(String ordertimestr) {
        this.ordertimestr = ordertimestr;
    }

    public String getPaytypestr() {
        if (paytype != null){
            if (paytype == 0)
                paytypestr = "支付宝";
            if (paytype == 1)
                paytypestr = "微信";
            if (paytype == 2)
                paytypestr = "其他";
        }
        return paytypestr;
    }

    public void setPaytypestr(String paytypestr) {
        this.paytypestr = paytypestr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member_tab getMember_tab() {
        return member_tab;
    }

    public void setMember_tab(Member_tab member_tab) {
        this.member_tab = member_tab;
    }

    public String getOrderstatusstr() {

        if (orderstatus != null){
            if (orderstatus == 0)
                this.orderstatusstr = "未支付";
            if (orderstatus == 1)
                this.orderstatusstr = "已支付";
        }

        return orderstatusstr;
    }

    public void setOrderstatusstr(String orderstatusstr) {
        this.orderstatusstr = orderstatusstr;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", ordernum='" + ordernum + '\'' +
                ", ordertime=" + ordertime +
                ", ordertimestr='" + ordertimestr + '\'' +
                ", peoplecount=" + peoplecount +
                ", orderdesc='" + orderdesc + '\'' +
                ", paytype=" + paytype +
                ", paytypestr='" + paytypestr + '\'' +
                ", orderstatus=" + orderstatus +
                ", productid='" + productid + '\'' +
                ", memberid='" + memberid + '\'' +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member_tab=" + member_tab +
                '}';
    }





}
