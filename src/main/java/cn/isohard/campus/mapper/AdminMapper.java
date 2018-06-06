package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.Category;
import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.entities.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 用管理员用户名查密码，查不到不登录，查到了与输入的密码不一致不登陆
     *
     * @param adminname
     * @return
     */
    @Select("select adminpassword from admin where adminname=#{adminname}")
    public String getAdminpasswordByAdminname(@Param("adminname") String adminname);

    /**
     * 查询出所有的用户
     *
     * @return
     */
    @Select("select * from user")
    public List<User> getAllUser();

    /**
     * 删除用户所有有关的信息By userid
     *
     * @param userid
     */
    @Delete("delete from user where userid = #{userid}")
    public void deleteUserByUserid(@Param("userid") Integer userid);

    @Delete("delete from goods where userid = #{userid}")
    public void deleteUserofGoodsByUserid(@Param("userid") Integer userid);

    @Delete("delete from favorite where userid = #{userid}")
    public void deleteUserofFavoriteByUserid(@Param("userid") Integer userid);

    /**
     * 查询所有的二手物品信息
     *
     * @return
     */
    @Select("select * from goods")
    public List<Goods> getAllGoodses();

    /**
     * 所有分类
     *
     * @return
     */
    @Select("select * from category")
    public List<Category> getAllCategory();

    /**
     * 根据分类ID查询分类信息
     *
     * @param categoryid
     * @return
     */
    @Select("select * from category where categoryid=#{categoryid}")
    public Category getCategoryByCategoryid(@Param("categoryid") Integer categoryid);

    /**
     * 插入一条分类信息
     *
     * @param category
     */
    @Insert("insert into category (description) value(#{description})")
    public void categoryInsert(Category category);

    /**
     * 更新分类信息
     * @param category
     */
    @Update("<script>" +
            "update category" +
            "<set>" +
            "description=#{description}" +
            "</set>" +
            "where categoryid=#{categoryid}" +
            "</script>")
    public void categoryUpdate(Category category);

    /**
     * 删除一条分类信息
     * @param categoryid
     */
    @Delete("delete from category where categoryid=#{categoryid}")
    public void categoryDelete(@Param("categoryid") Integer categoryid);

}
