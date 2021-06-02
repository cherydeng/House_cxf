package com.chery.deng.entity;


import java.io.Serializable;

public class People {
    /**
     * 属性
     */
    private int ID;
    private String Name;
    private String Iphone;
    private String Require;
    private int NeedTime;

    /**
     * 构造方法
     */
    People() {

    }

    People(int Id, String name, String iphone, String require, int needTime) {
        super();
        this.ID = Id;
        this.Name = name;
        this.Iphone = iphone;
        this.Require = require;
        this.NeedTime = needTime;
    }

    /**
     * get & set 方法
     *
     * @return 各属性
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public int getNeedTime() {
        return NeedTime;
    }

    public String getIphone() {
        return Iphone;
    }

    public String getRequire() {
        return Require;
    }

    public void setIphone(String iphone) {
        Iphone = iphone;
    }

    public void setNeedTime(int needTime) {
        NeedTime = needTime;
    }

    public void setRequire(String require) {
        Require = require;
    }

    /**
     *
     * @return people
     */
    @Override
    public String toString() {
        return "People[id=" + this.ID + ", Name=" + this.Name + ", iphone=" + this.Iphone + ", require=" + this.Require + ", needtime="
                + this.NeedTime + "]";
    }
}
