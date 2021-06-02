package com.chery.deng.dao.lmpl;

import com.chery.deng.Service.HouseService;
import com.chery.deng.dao.HouseDao;
import com.chery.deng.entity.House;
import com.chery.deng.entity.People;

import java.util.List;

public class HouseDaolmpl implements HouseDao {

    private HouseService houseDao;

    public  HouseDaolmpl(){ houseDao = new HouseService(); }

    @Override
    public int addinfo(House house) { return houseDao.addinfo(house); }

    @Override
    public int updateinfo(House house) {
        return houseDao.updateinfo(house);
    }

    @Override
    public int delectbook(String houseid) {
        return houseDao.delectbook(houseid);
    }

    @Override
    public List<House> gethouseall() { return houseDao.gethouseall(); }

    @Override
    public List<House> gethouse() {
        return houseDao.gethouse();
    }

    @Override
    public List<House> gethoursebyrentmoney(int money) {
        return houseDao.gethoursebyrentmoney(money);
    }

    @Override
    public List<House> gethoursebyhroom(String hroom) {
        return houseDao.gethoursebyhroom(hroom);
    }

    @Override
    public List<House> gethoursebyfloor(String floor) {
        return houseDao.gethoursebyfloor(floor);
    }

    @Override
    public List<House> gethoursebyarea(int area) {
        return houseDao.gethoursebyarea(area);
    }

    @Override
    public int addpeople(People people) {
        return houseDao.addpeople(people);
    }

    @Override
    public List<House> gethoursebyneedtime(String id) {
        return houseDao.gethoursebyneedtime(id);
    }

}
