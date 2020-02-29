package com.my.springcloud.service;

import com.my.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    void deleteByPrimaryKey(Long deptNo);

    Dept queryByPrimaryKey(Long deptNo);

    List<Dept> queryAll();
}
