package com.study.annotations.bean;

import com.study.annotations.anno.Colum;
import com.study.annotations.anno.Primary;
import com.study.annotations.anno.Table;
import java.util.Date;

@Table(name="t_user")
public class User {

    public User(String id, String name, Integer age, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Primary(pk=true)
    @Colum("id")
    private String id;

    @Colum("name")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
