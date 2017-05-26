package com.zg.dao;

import com.zg.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user;")
    List<User> list();

    @Select("SELECT id, name, age FROM user WHERE id=#{id}")
    User findByID(int id);

    @Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    @Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(int id);
}
