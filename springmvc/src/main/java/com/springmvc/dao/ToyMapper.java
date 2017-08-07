package com.springmvc.dao;

import com.springmvc.pojo.Toy;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Repository("toyMapper")
public interface ToyMapper {
    @Insert("insert into toy (name,price,create_date) values(#{name},#{price},#{createDate})")
    Integer add(Toy toy);

    @Update("update toy set name=#{name},price=#{price},create_date=#{createDate}")
    Integer modify(Toy toy);

    @Delete("delete from toy where id=#{id}")
    Integer remove(@Param("id") Integer id);

    @Select("select * from toy where id=#{id}")
    Toy findById(@Param("id") Integer id);

    List<Toy> findByPager(@Param("pageNo") Integer pageNo,
                          @Param("pageSize") Integer pageSize,
                          @Param("sort") String sort,
                          @Param("order") String order,
                          @Param("name") String name,
                          @Param("beginDate")Date beginDate,
                          @Param("endDate") Date endDate);

    Integer getTotal(@Param("name") String name,
                     @Param("beginDate")Date beginDate,
                     @Param("endDate") Date endDate);

    List<Toy> findByParam(@Param("name") String name);

}
