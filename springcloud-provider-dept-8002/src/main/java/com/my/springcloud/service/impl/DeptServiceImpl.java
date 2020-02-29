package com.my.springcloud.service.impl;

import com.my.springcloud.mapper.DeptMapper;
import com.my.springcloud.pojo.Dept;
import com.my.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public void deleteByPrimaryKey(Long deptNo) {
        deptMapper.deleteByPrimaryKey(deptNo);
    }

    @Override
    public Dept queryByPrimaryKey(Long deptNo) {
        return deptMapper.selectByPrimaryKey(deptNo);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.selectAll();
    }
}
