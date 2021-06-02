package com.chery.deng.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.sql.Connection;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")

public class jdbcConfig {
    /**
     * 配置数据库Url
     */
    @Value("${spring.datasource.url}")
    String url;
    /**
     * 加载数据库驱动程序
     */
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;
    /**
     * 数据库用户名称
     */
    @Value("${spring.datasource.username}")
    String username;
    /**
     * 数据库用户密码
     */
    @Value("${spring.datasource.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
