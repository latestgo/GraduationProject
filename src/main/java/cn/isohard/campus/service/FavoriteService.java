package cn.isohard.campus.service;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.mapper.FavoriteMapper;
import cn.isohard.campus.mapper.GoodsMapper;
import cn.isohard.campus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    public List<Goods> getFavoriteGoods(String username) {
        List<Goods> favoriteGoods = new ArrayList<>();
        Integer userid = userMapper.selectUseridByUsername(username);
        List<Integer> goodsid = favoriteMapper.selectGoodsidByUserid(userid);
        for(Integer goodsideach : goodsid) {
            favoriteGoods.add(goodsMapper.getGoodsById(goodsideach));
            System.out.println(favoriteGoods);
        }
        return favoriteGoods;
    }

    public void deleteFavoriteByGoodsid(Integer goodsid) {
        favoriteMapper.deleteFavoriteByGoodsid(goodsid);
    }
}
