package cn.isohard.campus.service;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getGoodsAll() {
        return goodsMapper.getGoodsAll();
    }

    public Goods getGoodsById(Integer goodsid) {
        return goodsMapper.getGoodsById(goodsid);
    }

    public void addGoods(Integer userid, Integer categoryid, String title, String description, Integer price) {
        goodsMapper.addGoods(userid, categoryid, title, description, price);
    }

    public List<String> getTitleByUserid(Integer userid) {
        return goodsMapper.getTitleByUserid(userid);
    }

    public List<Integer> getPriceByUserid(Integer userid) {
        return goodsMapper.getPriceByUserid(userid);
    }

    public List<Goods> getGoodsByUserid(Integer userid) {
        return goodsMapper.getGoodsByUserid(userid);
    }

    /**
     * 删除信息
     * @param goodsid
     */
    public void deleteGoodsByGoodsid(Integer goodsid) {
        goodsMapper.deleteGoodsByGoodsid(goodsid);
    }

    /**
     * 更新信息 by goodsid
     * @param goodsAttr
     * @param goodsValue
     * @param goodsid
     */
    public void updateGoodsByGoodsid(String goodsAttr, String goodsValue, Integer goodsid) {
        goodsMapper.updateGoodsByGoodsid(goodsAttr, goodsValue, goodsid);
    }
}
