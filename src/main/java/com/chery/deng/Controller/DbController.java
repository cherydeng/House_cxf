package com.chery.deng.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import com.chery.deng.config.jdbcConfig;
import java.sql.*;
import java.sql.Connection;

@RestController
public class DbController {
    @Autowired
    DataSource dataSource;
    @GetMapping("/dbtest")
    public String test() throws Exception{
        Connection con = dataSource.getConnection();
        return "数据库链接成功";
    }
}
