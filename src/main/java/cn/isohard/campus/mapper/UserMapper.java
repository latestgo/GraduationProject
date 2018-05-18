package cn.isohard.campus.mapper;

import cn.isohard.campus.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //通过username和password查询用户验证登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User selectUser(@Param("username") String username, @Param("password") String password);

    //通过username查询userid
    @Select("select userid from user where username=#{username}")
    Integer selectUseridByUsername(@Param("username") String username);

    //添加一个用户
    @Insert("insert into user (username, password) value(#{username}, #{password})")
    public void insertUser(@Param("username") String username, @Param("password") String password);
}
