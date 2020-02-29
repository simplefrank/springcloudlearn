package com.my.springcloud.mapper;

import com.my.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface DeptMapper {

    boolean insert(Dept dept);

    void deleteByPrimaryKey(Long deptNo);

    Dept selectByPrimaryKey(Long deptNo);

    List<Dept> selectAll();

}
