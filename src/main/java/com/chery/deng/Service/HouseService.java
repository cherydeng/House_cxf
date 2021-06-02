package com.chery.deng.Service;


import com.chery.deng.dao.HouseDao;
import com.chery.deng.dao.lmpl.HouseDaolmpl;
import com.chery.deng.entity.House;
import com.chery.deng.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.awt.print.Book;
import javax.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
     * @param house
     * @return
     */
    public int addinfo(House house){
        int count = 0;
        qr = new QueryRunner();
        try {
        con = dataSource.getConnection();
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
        return count;
    }

    /**
     *
     * @param house
     * @return
     */
    public int updateinfo(House house){
        int count = 0;
        qr = new QueryRunner();
        try{
            con = dataSource.getConnection();
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
        return count;
    }

    /**
     *
     * @param houseid
     * @return
     */
    public int delectbook(String houseid) {
        int count=0;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            count=qr.update(con, "delete from housers where houseid=?", houseid);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return count;
    }

    /**
     *
     * @return
     */
    public List<House> gethouseall() {
        List<House> count=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            count = qr.query(con, "select * from housers ", new BeanListHandler<>(House.class));
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return count;
    }

    /**
     *
     * @return
     */
    public List<House> gethouse() {
        List<House> count=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            count = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney from housers ", new BeanListHandler<>(House.class));
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return count;
    }

    /**
     *
     * @param money
     * @return
     */
    public List<House> gethoursebyrentmoney(int money) {
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney from housers where rentmoney <= ?", new BeanListHandler<>(House.class), money);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    /**
     *
     * @param hroom
     * @return
     */
    public List<House> gethoursebyhroom(String hroom) {
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney from housers where hroom =?", new BeanListHandler<>(House.class), hroom);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    /**
     *
     * @param floor
     * @return
     */
    public List<House> gethoursebyfloor(String floor) {
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney from housers where floor=?", new BeanListHandler<>(House.class), floor);
            con.close();
        }catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    /**
     *
     * @param area
     * @return
     */
    public List<House> gethoursebyarea(int area) {
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney from housers where area >=?", new BeanListHandler<>(House.class), area);
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    /**
     *
     * @param people
     * @return
     */
    public int addpeople(People people) {
        int cnt=0;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
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
        return cnt;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<House> gethoursebyneedtime(String id) {
        List<House> cnt=null;
        qr=new QueryRunner();
        try {
            con=dataSource.getConnection();
            People people=qr.query(con,"select needtime from people where ID=?", new BeanHandler<>(People.class),id);
            cnt = qr.query(con, "select houseid,area,hroom,floor,assort,renttime,rentmoney,owner,ipone from housers where renttime >=?", new BeanListHandler<>(House.class), people.getNeedTime());
            con.close();
        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return cnt;
    }

}
