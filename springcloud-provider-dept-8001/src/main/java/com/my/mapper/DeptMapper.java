package com.my.mapper;

import com.my.mapper.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface DeptMapper {

    void insert(Dept dept);

    void deleteByPrimaryKey(Integer deptNo);

    Dept selectByPrimaryKey(Integer deptNo);

}
