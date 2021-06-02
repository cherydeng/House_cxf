package com.chery.deng.DBconnectionTest;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;
import javax.sql.DataSource;
import com.chery.deng.config.jdbcConfig;
public class test {
    @Autowired
    DataSource dataSource;
    public void main(){
        System.out.println(dataSource);
    }
}
