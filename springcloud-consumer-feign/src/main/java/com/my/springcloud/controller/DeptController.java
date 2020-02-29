package com.my.springcloud.controller;

import com.my.springcloud.pojo.Dept;
import com.my.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/dept")
@Validated
public class DeptController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/add")
    public Dept add(Dept dept){
        return deptClientService.addDept(dept);
    }

    @PostMapping("/delete")
    public void delete(@NotNull(message = "部门编号不能为空") Long deptNo){
        deptClientService.deleteById(deptNo);
    }

    @GetMapping("/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return deptClientService.queryById(deptNo);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptClientService.queryAll();

    }
}
