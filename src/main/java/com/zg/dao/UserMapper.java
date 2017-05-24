package com.zg.dao;

import com.zg.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT id, name, age FROM user WHERE id=#{id}")
    User findByID(int id);

    @Insert("INSERT INTO user(name, age) VALUES (#{user.id}, #{user.name})")
    int insert(User user);
}
