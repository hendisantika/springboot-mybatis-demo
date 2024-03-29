package com.hendisantika.springbootmybatisdemo.controller;

import com.hendisantika.springbootmybatisdemo.entity.User;
import com.hendisantika.springbootmybatisdemo.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("new")
    public String getUserNew(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/new";
    }

    @PostMapping
    public String postUserCreate(@ModelAttribute @Valid User user,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userMapper.insert(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String getUserEdit(@PathVariable int id, Model model) {
        User user = userMapper.select(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PutMapping("{id}")
    public String putUserEdit(@PathVariable int id, @ModelAttribute @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        user.setId(id);
        userMapper.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        userMapper.delete(id);
        return "redirect:/users";
    }
}
