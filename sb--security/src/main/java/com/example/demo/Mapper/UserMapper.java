package com.example.demo.Mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Select( "select id , username , password from user where username = #{username}" )
    User loadUserByUsername(@Param("username") String username);

}
