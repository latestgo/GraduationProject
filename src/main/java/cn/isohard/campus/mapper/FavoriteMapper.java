package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    @Select("select goodsid from favorite where userid=#{userid}")
    public List<Integer> selectGoodsidByUserid(@Param("userid") Integer userid);

    @Delete("delete from favorite where goodsid=#{goodsid}")
    public void deleteFavoriteByGoodsid(@Param("goodsid") Integer goodsid);
}
