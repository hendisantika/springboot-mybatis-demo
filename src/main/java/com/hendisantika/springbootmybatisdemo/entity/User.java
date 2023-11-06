package com.hendisantika.springbootmybatisdemo.entity;


import jakarta.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mybatis-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-17
 * Time: 04:35
 */
public class User {

    private int id;

    @NotBlank(message = "{require_check}")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
