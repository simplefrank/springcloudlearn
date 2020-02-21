package com.my.springcloud.controller;

import com.my.springcloud.pojo.Dept;
import com.my.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/dept")
@Validated
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public Dept add(Dept dept){
        deptService.add(dept);
        return deptService.queryByPrimaryKey(dept.getDeptNo());
    }

    @PostMapping("/delete")
    public void delete(@NotNull(message = "部门编号不能为空") Long deptNo){
        deptService.deleteByPrimaryKey(deptNo);
    }

    @GetMapping("/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return deptService.queryByPrimaryKey(deptNo);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.queryAll();
    }
}
