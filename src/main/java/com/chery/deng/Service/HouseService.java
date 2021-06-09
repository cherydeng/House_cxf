package com.chery.deng.Service;


//import com.chery.deng.config.DBConnect;
import com.chery.deng.dao.HouseDao;
import java.util.Date;
import com.chery.deng.dao.lmpl.HouseDaolmpl;
import com.chery.deng.entity.House;
import com.chery.deng.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.awt.print.Book;
import javax.annotation.Resource;
import javax.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.chery.deng.config.DBConnect;

import java.sql.Time;
import java.util.List;
//import com.chery.deng.config.jdbcConfig;
import org.springframework.web.bind.annotation.RestController;

public class HouseService{
    @Autowired
    DataSource dataSource;

    /**
     * 各属性
     */
    private Connection con;
    private QueryRunner qr;
    public HouseService (){
    }

    /**
     *
     * @param
     * @return
     */
    public static Long getTimestamp(Date date){
        if (null == date) {
            return (long) 0;
        }
        String timestamp = String.valueOf(date.getTime());
        return Long.valueOf(timestamp);
    }

    public int addinfo(House house){
        int count = 0;
        Date d = new Date();
        qr = new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            count = qr.update(con,"insert into housers values(?,?,?,?,?,?,?,?,?,?)",
                    house.getHouseid(),
                    house.getArea(),
                    house.getHroom(),
                    house.getFloor(),
                    house.getAddr(),
                    house.getAssort(),
                    house.getRenttime(),
                    house.getRentmoney(),
                    house.getOwner(),
                    house.getIpone()
            );
            con.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("加入信息完成"+getTimestamp(d));
        return count;
    }

    /**
     *
     * @param house
     * @return
     */
    public int updateinfo(House house){
        int count = 0;
        Date d = new Date();
        qr = new QueryRunner();
        try{
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            count = qr.update(con, "update housers set area=?,hroom=?,floor=?,addr=?,assort=?,renttime=?,rentmoney=?,owner=?,ipone=? where houseid=?",
                    house.getArea(),
                    house.getHroom(),
                    house.getFloor(),
                    house.getAddr(),
                    house.getAssort(),
                    house.getRenttime(),
                    house.getRentmoney(),
                    house.getOwner(),
                    house.getIpone(),
                    house.getHouseid()
            );
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("更新信息完成"+getTimestamp(d));
        return count;
    }

    /**
     *
     * @param houseid
     * @return
     */
    public int delectbook(String houseid) {
        int count=0;
        Date d = new Date();
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            count=qr.update(con, "delete from housers where houseid=?", houseid);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("用过房间号找房子"+getTimestamp(d));
        return count;
    }

    /**
     *
     * @return
     */
    public List<House> gethouseall() {
        Date d = new Date();
        List<House> count=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            count = qr.query(con, "select * from housers ", new BeanListHandler<>(House.class));
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("遍历所有房子"+getTimestamp(d));
        return count;
    }

    /**
     *
     * @return
     */
    public List<House> gethouse() {
        Date d = new Date();
        List<House> count=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            count = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,addr,owner,ipone from housers ", new BeanListHandler<>(House.class));
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        System.out.println("获取所有的房源"+getTimestamp(d));
        return count;
    }

    /**
     *
     * @param money
     * @return
     */
    public List<House> gethoursebyrentmoney(int money) {
        Date d = new Date();
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,addr,owner,ipone from housers where rentmoney <= ?", new BeanListHandler<>(House.class), money);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("通过租金查询操作完成"+getTimestamp(d));
        return cnt;
    }

    /**
     *
     * @param hroom
     * @return
     */
    public List<House> gethoursebyhroom(String hroom) {
        Date d = new Date();
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,addr,owner,ipone from housers where hroom =?", new BeanListHandler<>(House.class), hroom);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("通过房子类型查询操作完成"+getTimestamp(d));
        return cnt;
    }

    /**
     *
     * @param floor
     * @return
     */
    public List<House> gethoursebyfloor(String floor) {
        Date d = new Date();
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,addr,owner,ipone from housers where floor=?", new BeanListHandler<>(House.class), floor);
            con.close();
        }catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("通过楼层查询操作完成"+getTimestamp(d));
        return cnt;
    }

    /**
     *
     * @param area
     * @return
     */
    public List<House> gethoursebyarea(int area) {
        Date d = new Date();
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,addr,owner,ipone from housers where area >=?", new BeanListHandler<>(House.class), area);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("通过面积查询操作完成"+getTimestamp(d));
        return cnt;
    }

    /**
     *
     * @param people
     * @return
     */
    public int addpeople(People people) {
        Date d = new Date();
        int cnt=0;
        qr=new QueryRunner();
        try {
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
            cnt = qr.update(con, "insert into people values(?,?,?,?,?)",
                    people.getID(),
                    people.getName(),
                    people.getIphone(),
                    people.getRequire(),
                    people.getNeedTime()
            );
            con.close();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("注册操作完成"+getTimestamp(d));
        return cnt;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<House> gethoursebyneedtime(String id){
        Date d = new Date();
//        System.out.println(dataSource.getClass());
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
//            System.out.println(dataSource.getConnection());
            con = DBConnect.getConnection();
//            con =dataSource.getConnection();
//            System.out.println(con);
            People people=qr.query(con,"select needtime from people where ID=?", new BeanHandler<>(People.class),id);
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,owner,ipone from housers where renttime >=?", new BeanListHandler<>(House.class), people.getNeedTime());
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("通过需求查询操作完成"+getTimestamp(d));
        return cnt;
    }

}
