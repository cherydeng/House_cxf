package com.chery.deng.entity;

import java.io.Serializable;

public class House implements Serializable {
    private String houseid;         //房屋id
    private int area;               //房屋大小
    private String hroom;           //房屋类型
    private String floor;           //几层楼
    private String addr;            //地址
    private String assort;          //设施情况
    private int renttime;           //租借时间
    private int rentmoney;          //租金
    private String owner;           //房屋拥有者
    private String ipone;           //电话号码

    /**
     * 无参构造函数
     */
    public House() {
    }

    /**
     *
     * @param houseid 房屋id
     * @param area 房屋大小
     * @param hroom 房屋类型
     * @param floor 几层楼
     * @param addr 地址
     * @param assort 设施情况
     * @param renttime 租借时间
     * @param rentmoney 租金
     * @param owner 房屋拥有者
     * @param ipone 电话号码
     */
    public House(String houseid, int area, String hroom, String floor, String addr, String assort, int renttime,
                     int rentmoney, String owner, String ipone) {
        super();
        this.houseid = houseid;
        this.area = area;
        this.hroom = hroom;
        this.floor = floor;
        this.addr = addr;
        this.assort = assort;
        this.renttime = renttime;
        this.rentmoney = rentmoney;
        this.owner = owner;
        this.ipone = ipone;
    }

    /**
     * Get&set方法
     * @return 各参数
     */
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }
    public String getAddr() {
        return addr;
    }

    public int getRenttime() {
        return renttime;
    }

    public String getAssort() {
        return assort;
    }

    public String getFloor() {
        return floor;
    }

    public String getHouseid() {
        return houseid;
    }

    public String getHroom() {
        return hroom;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setAssort(String assort) {
        this.assort = assort;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public int getRentmoney() {
        return rentmoney;
    }

    public void setHroom(String hroom) {
        this.hroom = hroom;
    }

    public void setRentmoney(int rentmoney) {
        this.rentmoney = rentmoney;
    }

    public void setRenttime(int renttime) {
        this.renttime = renttime;
    }

    public String getIpone() {
        return ipone;
    }

    public String getOwner() {
        return owner;
    }

    public void setIpone(String ipone) {
        this.ipone = ipone;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return to String()
     */
    @Override
    public String toString() {
        return "IWQ1House [houseid=" + houseid + ", area=" + area + ", hroom=" + hroom + ", floor=" + floor + ", addr="
                + addr + ", assort=" + assort + ", renttime=" + renttime + ", rentmoney=" + rentmoney + ", owner="
                + owner + ", ipone=" + ipone + "]";
    }

}

