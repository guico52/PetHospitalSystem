package com.guico.pojo;

import org.springframework.lang.Nullable;

public class Emp {
    private int id;
    private String name;
    private String password;
    private String email;

//    构造函数，id可为空，原因是如果插入数据库，id是自增的，不需要插入
    public Emp(@Nullable int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
