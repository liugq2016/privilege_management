package cn.lgq.www.domain;

import cn.lgq.www.utils.Date_StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * product表的实体类
 */
public class Product {

    private String id = null;//主键
    private String productnum = null;//编号 唯一
    private String productname = null;// 名称
    private String cityname = null;// 出发城市

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date timestamp = null;// 出发时间

    private String departuretimestr = null;
    private Double productprice = null;// 产品价格
    private String productdesc = null;// 产品描述
    private Integer productstatus = null;// 状态 0 关闭 1 开启
    private String productstatusstr = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductnum() {
        return productnum;
    }

    public void setProductnum(String productnum) {
        this.productnum = productnum;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public Integer getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(Integer productstatus) {
        this.productstatus = productstatus;
    }

    public String getDeparturetimestr() {
        if (this.timestamp != null){
            this.departuretimestr = Date_StringUtils.dateToString(timestamp,"YYYY-mm-dd hh:mm:ss");
        }
        return departuretimestr;
    }

    public void setDeparturetimestr(String departureTimeStr) {
            this.departuretimestr = departureTimeStr;
    }

    public String getProductstatusstr() {
        if (productstatus != null){
            if (productstatus == 0)
                productstatusstr = "关闭";
            if (productstatus == 1)
                productstatusstr = "开启";
        }
        return productstatusstr;
    }

    public void setProductstatusstr(String productStatusStr) {
            this.productstatusstr = productStatusStr;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productnum='" + productnum + '\'' +
                ", productname='" + productname + '\'' +
                ", cityname='" + cityname + '\'' +
                ", timestamp=" + timestamp +
                ", departureTimeStr='" + departuretimestr + '\'' +
                ", productprice=" + productprice +
                ", productdesc='" + productdesc + '\'' +
                ", productstatus=" + productstatus +
                ", productStatusStr='" + productstatusstr + '\'' +
                '}';
    }
}
