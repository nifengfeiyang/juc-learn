package com.szm;

import java.util.Arrays;
import java.util.List;

class User{
    private int id;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 查询id为偶数，年龄大于24，姓名转为大写，倒叙排序，取第一条
 */
public class SteamDemo {
    public static void main(String[] args) throws Exception {
        User u1 = new User(1,25,"a");
        User u2 = new User(2,18,"b");
        User u3 = new User(3,24,"c");
        User u4 = new User(4,26,"d");
        User u5 = new User(6,28,"e");

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream()
//                .filter(user ->  {return user.getId() % 2 == 0;})
                .filter(user ->  user.getId() % 2 == 0)
                .filter(user -> {return user.getAge() > 24;})
                .map(user -> { return user.getName().toUpperCase();})
                .sorted((o1, o2) -> {return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
