package com.springmvc.controller;

import com.springmvc.pojo.Toy;
import com.springmvc.service.ToyService;
import com.springmvc.util.JsonDateValueProcessor;
import com.springmvc.util.Pager;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class ToyController {

    @Resource(name = "toyService")
    private ToyService toyService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }
    @RequestMapping("list")
    public String goList() {
        return "list";
    }

    @RequestMapping(value = "toys",method = RequestMethod.POST,
                    produces = "application/json;charset=UTF-8")
    public @ResponseBody String list(
            @RequestParam(value = "page",required = true)Integer page,
            @RequestParam(value = "rows",required = true) Integer rows,
            @RequestParam(value = "sort",required = true) String sort,
            @RequestParam(value = "order",required = true) String order,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "beginDate",required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
            @RequestParam(value = "endDate",required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        System.out.println(sort+" "+order);
        Integer pageNo = (page-1)*rows;
        Integer pageSize = 0;
        if(rows>toyService.getTotal(name,beginDate,endDate)) {
            pageSize = toyService.getTotal(name,beginDate,endDate);
        }else{
            pageSize = rows;
        }



        System.out.println(beginDate+" "+endDate);

        Pager<Toy> pager = toyService.findPager(pageNo,pageSize,sort,order,name,beginDate,endDate);

        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(pager,jc);
        System.out.println(json.toString());

        return json.toString();
    }


}
