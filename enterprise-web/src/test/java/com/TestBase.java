package com;

import com.dao.TimeAxisDao;
import com.dao.UserDao;
import com.model.TimeAxis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-26 下午 5:00
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestBase {
    @Autowired
    UserDao userDao;
    @Autowired
    TimeAxisDao timeAxisDao;
    @Test
    public void testInsert() {
        TimeAxis timeAxis = new TimeAxis();
        timeAxis.setDate(new Date());
        timeAxis.setPhotoUrl("ssd");
        timeAxis.setContext("asdf");
        timeAxisDao.save(timeAxis);
    }
    @Test
    public void findOne() {
        int id=2;
        TimeAxis one = timeAxisDao.findOne(id);
        System.out.println(one);
    }
}
