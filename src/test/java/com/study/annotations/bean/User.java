package com.study.annotations.bean;

import com.study.annotations.anno.Colum;
import com.study.annotations.anno.Primary;
import com.study.annotations.anno.Table;
import java.util.Date;

@Table(name="t_user")
public class User {
    public User() {

    }

    public User(String id, String name, Integer age, Date birthday) {
        this.id = id;
        this.username = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Primary(pk=true)
    @Colum("id")
    private String id;

    @Colum("username")
    private String username;

    @Colum("password")
    private String password;

    @Colum("age")
    private Integer age;

    @Colum("date")
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
