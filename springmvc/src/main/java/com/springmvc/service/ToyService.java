package com.springmvc.service;

import com.springmvc.dao.ToyMapper;
import com.springmvc.pojo.Toy;
import com.springmvc.util.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service("toyService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ToyService {

    @Resource(name = "toyMapper")
    private ToyMapper toyMapper;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer add(Toy toy) {
        return toyMapper.add(toy);
    }

    public Pager<Toy> findPager( Integer pageNo,
                                 Integer pageSize,
                                 String sort,
                                 String order,
                                 String name,
                                 Date beginDate,
                                 Date endDate) {
        Pager<Toy> pager = new Pager<>();
        pager.setRows(toyMapper.findByPager(pageNo,pageSize,sort,order,name,beginDate,endDate));
        pager.setTotal(toyMapper.getTotal(name,beginDate,endDate));
        return pager;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer modify(Toy toy) {
        return toyMapper.modify(toy);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer remove(Integer id) {
        return toyMapper.remove(id);
    }

    public List<Toy> findByParam(String name) {
        return toyMapper.findByParam(name);
    }

    public Integer getTotal(String name,Date beginDate,Date endDate) {
        return toyMapper.getTotal(name,beginDate,endDate);
    }
}
