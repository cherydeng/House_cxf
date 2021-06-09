package com.chery.deng.Controller;

import com.chery.deng.Service.HouseService;
import com.chery.deng.config.DBConnect;
import com.chery.deng.entity.House;
import com.chery.deng.entity.People;
import com.sun.xml.bind.v2.model.core.ID;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.eclipse.jetty.http.MetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import com.chery.deng.config.jdbcConfig;
import java.sql.*;
import java.sql.Connection;
import java.util.List;

@Controller
public class DbController {
    @Autowired
    DataSource dataSource;

    @ResponseBody
    @GetMapping("/test")
    public String test() throws Exception{
//        Connection con = DBConnect.getConnection();
//        dataSource = new jdbcConfig().dataSource();
        HouseService houseService = new HouseService();
        List<House> Houses1 = houseService.gethoursebyneedtime("10418234");
        for (House Houses : Houses1) {
            System.out.println(Houses);
//            System.out.println(dataSource.getClass());
//            System.out.println(dataSource.getConnection());
//          Connection con = dataSource.getConnection();
//        Connection con=DBConnect.getConnection();
//        QueryRunner qr=new QueryRunner();
//        PreparedStatement ps = con.prepareStatement("select * from people");
//        System.out.println(new BeanHandler<>(People.class));
//        People people=qr.query(con,"select * from people",new BeanHandler<>(People.class));
//        System.out.println(people);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getInt("ID"));
//        }

        }
        return "OK";
    }
//    @ResponseBody
//    @GetMapping("/people/login")
//    public int login(@RequestBody People people) throws Exception{
//        Connection con = dataSource.getConnection();
//        QueryRunner qr = new QueryRunner();
//        People people1 = qr.query(con,"selcet * from people",new BeanHandler<>(People.class));
//        if (people.getID() == people1.getID() && people.getPassword() == people1.getPassword()) {
//            return 1;
//        }
//        return 0;
//    }
//    @RequestMapping("/index")
//    public String login1(){
//        return "login";
    }
