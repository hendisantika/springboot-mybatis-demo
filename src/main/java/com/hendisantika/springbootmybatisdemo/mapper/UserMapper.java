package com.hendisantika.springbootmybatisdemo.mapper;

import com.hendisantika.springbootmybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mybatis-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-17
 * Time: 04:36
 */
@Repository
@Mapper
public interface UserMapper {

    List<User> selectAll();

    User select(int id);

    int insert(User user);

    int update(User user);

    int delete(int id);

}
