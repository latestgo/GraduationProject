package cn.isohard.campus.service;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private FavoriteService favoriteService;

    public List<Goods> getGoodsAll() {
        return goodsMapper.getGoodsAll();
    }

    public Goods getGoodsById(Integer goodsid) {
        return goodsMapper.getGoodsById(goodsid);
    }


    /**
     * 添加一条二手信息
     * @param goods
     */
    public void addGoods(Goods goods) {
        Date d = new Date(); System.out.println(d);
        goods.setPublishtime(d);
        goodsMapper.addGoods(goods);
    }

    public List<String> getTitleByUserid(Integer userid) {
        return goodsMapper.getTitleByUserid(userid);
    }

    public List<Integer> getPriceByUserid(Integer userid) {
        return goodsMapper.getPriceByUserid(userid);
    }

    /**
     * 得到userid发布的商品
     * @param userid
     * @return
     */
    public List<Goods> getGoodsByUserid(Integer userid) {
        return goodsMapper.getGoodsByUserid(userid);
    }

    /**
     * 删除信息
     * @param goodsid
     */
    public void deleteGoodsByGoodsid(Integer goodsid) {
        //先删除被收藏的
        favoriteService.deleteFavoriteByGoodsid(goodsid);
        goodsMapper.deleteGoodsByGoodsid(goodsid);
    }

    /**
     * 更新信息 by goodsid
     * @param goods
     */
    public void updateGoods(Goods goods) {
        goods.setPublishtime(new Date());
        goodsMapper.updateGoods(goods);
        //goodsMapper.updateGoodsByGoodsid("description", goodsValue, goodsid);
    }

    /**
     * 分页插件查询所有Goods
     * @param pageNum  其实就是开始的行数从0开始，pageNum=0 就是数据库中的第一行
     * @param pageSize
     */
    public List<Goods> getAllGoodsByPage(Integer pageNum, Integer pageSize) {
        System.out.println(pageNum);
        Integer startRow = (pageNum - 1) * pageSize;
        System.out.println(startRow);
        PageHelper.offsetPage(startRow, pageSize);
        List<Goods> GoodsList = goodsMapper.getGoodsAll();
        return GoodsList;
    }

}
