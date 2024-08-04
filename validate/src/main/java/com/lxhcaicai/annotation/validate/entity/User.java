package com.lxhcaicai.annotation.validate.entity;

import com.lxhcaicai.annotation.validate.annotation.Length;
import com.lxhcaicai.annotation.validate.annotation.NotNull;

public class User {

    @NotNull
    private String name;

    @Length(min = 6, max=10)
    @NotNull
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String password) {
        this.password = password;
    }
}
