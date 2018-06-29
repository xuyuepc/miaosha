package com.kyle.miaosha.dao;

import com.kyle.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(int id);

    @Insert("insert into user (id,name) values (#{id},#{name})")
    void insert(User user);
}
