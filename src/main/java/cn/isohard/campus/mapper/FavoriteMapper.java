package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.Favorite;
import cn.isohard.campus.entities.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    @Select("select goodsid from favorite where userid=#{userid}")
    public List<Integer> selectGoodsidByUserid(@Param("userid") Integer userid);

    @Delete("delete from favorite where goodsid=#{goodsid}")
    public void deleteFavoriteByGoodsid(@Param("goodsid") Integer goodsid);

    /**
     * 添加收藏
     */
    @Insert("insert into favorite (userid, goodsid) value(#{userid}, #{goodsid})")
    public void addFavorite(@Param("userid") Integer userid, @Param("goodsid") Integer goodsid);

    /**
     * 查询 goodsid 和 userid 出现在收藏表没
     * @param userid
     * @param goodsid
     * @return
     */
    @Select("select * from favorite where userid=#{userid} and goodsid=#{goodsid}")
    public Favorite isFavorite(@Param("userid") Integer userid, @Param("goodsid") Integer goodsid);
}
