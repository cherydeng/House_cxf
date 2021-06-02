package com.chery.deng.dao;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.chery.deng.entity.House;
import com.chery.deng.entity.People;

@WebService
public interface HouseDao {

    @WebMethod
    int addinfo(House house);

    /**
     *
     * @param house 房子
     * @return house
     */

    @WebMethod
    int updateinfo(House house);
    /**
     *
     * @param houseid 房子id
     * @return houseid
     */
    @WebMethod
    int delectbook(String houseid);

    /**
     *
     * @return house
     */
    @WebMethod
    List<House> gethouseall();

    /**
     *
     * @return house
     */
    @WebMethod
    List<House> gethouse();

    /**
     *
     * @param money 房租
     * @return
     */
    @WebMethod
    List<House> gethoursebyrentmoney(int money);

    /**
     *
     * @param hroom 房子类型
     * @return
     */
    @WebMethod
    List<House> gethoursebyhroom(String hroom);

    /**
     *
     * @param floor 房子层数
     * @return
     */
    @WebMethod
    List<House> gethoursebyfloor(String floor);

    /**
     *
     * @param area 房子大小
     * @return
     */
    @WebMethod
    List<House> gethoursebyarea(int area);

    @WebMethod
    int addpeople(People people);

    @WebMethod
    List<House> gethoursebyneedtime(String id);

}



