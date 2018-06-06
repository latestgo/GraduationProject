package cn.isohard.campus.service;

import cn.isohard.campus.entities.Favorite;
import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.mapper.FavoriteMapper;
import cn.isohard.campus.mapper.GoodsMapper;
import cn.isohard.campus.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
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

    /**
     * get list of favorite goods by page
     * @param username
     * @return
     */
    public List<Integer> getFavoriteGoods(String username, Integer pageNum, Integer pageSize) {
        Integer userid = userMapper.selectUseridByUsername(username);
        Integer startRow = (pageNum - 1) * pageSize;
        PageHelper.offsetPage(startRow, pageSize);
        //start to spit page
        List<Integer> favoriteGoodsId = favoriteMapper.selectGoodsidByUserid(userid);
        return favoriteGoodsId;
    }

    public void deleteFavoriteByGoodsid(Integer goodsid) {
        favoriteMapper.deleteFavoriteByGoodsid(goodsid);
    }

    /**
     * 添加收藏
     * @param userid
     * @param goodsid
     */
    public void addFavorite(Integer userid, Integer goodsid) {
        favoriteMapper.addFavorite(userid, goodsid);
    }


    public boolean isFavorite(Integer userid, Integer goodsid) {
        Favorite favorite = favoriteMapper.isFavorite(userid, goodsid);
        if (favorite !=null) {
            return true;
        }else {
            return false;
        }
    }

}
