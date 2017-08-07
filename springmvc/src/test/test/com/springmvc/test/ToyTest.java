package com.springmvc.test;

import com.springmvc.pojo.Toy;
import com.springmvc.service.ToyService;
import com.springmvc.util.Pager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToyTest {

    private ToyService toyService;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        toyService = ctx.getBean("toyService",ToyService.class);
    }

    @Test
    public void add() {
        Toy toy = new Toy();
        toy.setName("水枪");
        toy.setPrice(55d);
        toy.setCreateDate(new Date());
        toyService.add(toy);
    }

    @Test
    public void find() {
        Integer pageNo = 2;
        Integer pageSize = 2;
        pageNo = (pageNo-1)*pageSize;
        String sort = "name";
        String order = "asc";
        String name = null;
        Date beginDate = null;
        Date endDate = null;

        /*String s1 = "2017-07-05 00:00:00";
        String s2 = "2017-07-18 23:59:59";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try{
            beginDate = sdf.parse(s1);
            endDate = sdf.parse(s2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(beginDate+" "+endDate);*/
        Pager<Toy> pager = toyService.findPager(pageNo,pageSize,sort,order,name,beginDate,endDate);
        System.out.println(pager.getTotal());
        for(Toy toy : pager.getRows()) {
            System.out.println(toy.getName());
        }

    }

}
