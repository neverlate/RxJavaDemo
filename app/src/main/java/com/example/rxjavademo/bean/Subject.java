package com.example.rxjavademo.bean;

/**
 * 作者: sand 时间: 2016/10/24 21:11
 * 邮箱:yaohaobing@163.com
 */

public class Subject  {
    private int id;
    private String title;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "名：" + name + "\n标题:" + title;
    }
}
