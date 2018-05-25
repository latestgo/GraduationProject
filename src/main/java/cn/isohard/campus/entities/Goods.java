package cn.isohard.campus.entities;

import java.awt.*;
import java.util.Date;

public class Goods {

    private Integer goodsid;

    private Integer userid;

    private Integer categoryid;

    private String  title;

    private String description;

    private Integer price;

    private boolean status;

    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;

    private Image image5;

    private Date publishtime;

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public Image getImage3() {
        return image3;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }

    public Image getImage4() {
        return image4;
    }

    public void setImage4(Image image4) {
        this.image4 = image4;
    }

    public Image getImage5() {
        return image5;
    }

    public void setImage5(Image image5) {
        this.image5 = image5;
    }

    public Goods() {
        super();
    }

    public Goods(Integer goodsid, Integer userid, Integer categoryid, String title, String description, Integer price, boolean status, Image image1, Image image2, Image image3, Image image4, Image image5, Date publishtime) {
        super();
        this.goodsid = goodsid;
        this.userid = userid;
        this.categoryid = categoryid;
        this.title = title;
        this.description = description;
        this.price = price;
        this.status = status;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.publishtime = publishtime;
    }


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
