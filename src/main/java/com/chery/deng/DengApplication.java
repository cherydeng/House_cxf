package com.chery.deng;

import com.chery.deng.dao.HouseDao;
import com.chery.deng.dao.lmpl.HouseDaolmpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DengApplication {

    public static void main(String[] args) {
        SpringApplication.run(DengApplication.class, args);
        JaxWsServerFactoryBean bean = new JaxWsServerFactoryBean();
        bean.setAddress("http://localhost:10892/House?wsdl");
        bean.setServiceClass(HouseDao.class);
        bean.setServiceBean(new HouseDaolmpl());
        Server server=bean.create();
        server.start();
        System.out.println("服务器启动");
    }


}
