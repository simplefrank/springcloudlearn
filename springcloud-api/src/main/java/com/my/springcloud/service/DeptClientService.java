package com.my.springcloud.service;

import com.my.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("SPRINGCLOUD-PROVIDER-DEPT")
@Component
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @PostMapping("/dept/delete")
    void deleteById(Long deptNo);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    Dept addDept(Dept dept);

}
