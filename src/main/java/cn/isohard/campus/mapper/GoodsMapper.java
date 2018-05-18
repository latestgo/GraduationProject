package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface GoodsMapper {

    //查询所有发布的信息
    @Select("select * from goods where status= 1 ")
    public List<Goods> getGoodsAll();

    //通过goodid查询商品
    @Select("select * from goods where goodsid=#{goodsid}")
    public Goods getGoodsById(@Param("goodsid") Integer goodsid);

    //插入一条信息
    @Insert("insert into goods (userid, categoryid, title, description, price) value(#{userid,}, #{categoryid}, #{title}, #{description}, #{price})")
    public void addGoods(@Param("userid") Integer userid, @Param("categoryid") Integer categoryid, @Param("title") String goodsname, @Param("description") String description, @Param("price") Integer price);

    /**
     * 通过userid查询title
     * @param userid
     * @return
     */
    @Select("select title from goods where userid=#{userid}")
    public List<String> getTitleByUserid(@Param("userid") Integer userid);

    /**
     * 通过userid查询price
     * @param userid
     * @return
     */
    @Select("select price from goods where userid=#{userid}")
    public List<Integer> getPriceByUserid(@Param("userid") Integer userid);

    /**
     * 通过userid查询goods
     * @param userid
     * @return
     */
    @Select("select * from goods where userid=#{userid}")
    public List<Goods> getGoodsByUserid(@Param("userid") Integer userid);

    /**
     * 通过goodsid删除信息
     * @param goodsid
     */
    @Delete("delete from goods where goodsid=#{goodsid}")
    public void deleteGoodsByGoodsid(@Param("goodsid") Integer goodsid);

    @Update("update goods set #{goodsAttr} = #{goodsValue} where goodsid = #{goodsid}")
    public void updateGoodsByGoodsid(@Param("goodsAttr") String goodsAttr, @Param("goodsValue") String goodsVaule, @Param("goodsid") Integer goodsid);
}
