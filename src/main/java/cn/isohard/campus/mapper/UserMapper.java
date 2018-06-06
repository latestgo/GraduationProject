package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //通过username和password查询用户验证登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User selectUser(@Param("username") String username, @Param("password") String password);

    //通过username查询userid
    @Select("select userid from user where username=#{username}")
    Integer selectUseridByUsername(@Param("username") String username);

    /*
     * 查找一个用户
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    User getUserByUsername(@Param("username") String username);

    //添加一个用户
    @Insert("insert into user (username, password, phone, realname, studentid) value(#{username}, #{password}, #{phone}, #{realname}, #{studentid})")
    public void insertUser(User user);

    /**
     * update user by userid
     * @param user
     */
    @Update("<script>" +
            "update user" +
            "<set>" +
            "<if test='password != null'>password=#{password},</if>" +
            "<if test='phone !=null'>phone=#{phone}, </if>" +
            "<if test='realname != null'>realname=#{realname}, </if>" +
            "<if test='studentid != null'>studentid=#{studentid}, </if>" +
            "</set>" +
            "where userid=#{userid};" +
            "</script>")
    public void updateUser(User user);

    /**
     * get User By userid
     * @param userid
     * @return
     */
    @Select("select * from user where userid=#{userid}")
    public User getUserByUserid(@Param("userid") Integer userid);

}
