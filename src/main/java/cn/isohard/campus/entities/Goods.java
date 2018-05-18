package cn.isohard.campus.entities;

import java.util.Date;

public class Goods {

    private Integer goodsid;

    private Integer userid;

    private Integer categoryid;

    private String  title;

    private String description;

    private Integer price;

    private boolean status;

    @Override
    public String toString() {
        return "goods{" +
                "goodsid=" + goodsid +
                ", userid=" + userid +
                ", categoryid=" + categoryid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", publishtime=" + publishtime +
                '}';
    }

    private Date publishtime;

    //fixme
    //图片操作

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Goods() {
        super();
    }

    public Goods(Integer goodsid, Integer userid, Integer categoryid, String title, String description, Integer price, boolean status, Date publishtime) {
        this.goodsid = goodsid;
        this.userid = userid;
        this.categoryid = categoryid;
        this.title = title;
        this.description = description;
        this.price = price;
        this.status = status;
        this.publishtime = publishtime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
