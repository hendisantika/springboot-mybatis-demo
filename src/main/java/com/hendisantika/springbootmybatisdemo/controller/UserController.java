package com.hendisantika.springbootmybatisdemo.controller;

import com.hendisantika.springbootmybatisdemo.entity.User;
import com.hendisantika.springbootmybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mybatis-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-17
 * Time: 04:37
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public String getUsers(Model model) {
        List<User> users = userMapper.selectAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("{id}")
    public String getUser(@PathVariable int id, Model model) {
        User user = userMapper.select(id);
        model.addAttribute("user", user);
        return "users/show";
    }
}
