package cn.isohard.campus.entities;

public class Favorite {

    private Integer userid;

    private Integer goodsid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Favorite(Integer userid, Integer goodsid) {
        this.userid = userid;
        this.goodsid = goodsid;
    }
}
