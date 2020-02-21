package com.my.springcloud.controller;

import com.my.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
@Validated
public class DeptController {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Dept add(Dept dept){
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("deptName", dept.getDeptName());
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", params,  Dept.class);
    }

    @PostMapping("/delete")
    public void delete(@NotNull(message = "部门编号不能为空") Long deptNo){
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("deptNo", deptNo);
        restTemplate.postForObject(REST_URL_PREFIX + "/dept/delete", params, boolean.class);
    }

    @GetMapping("/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, Dept.class);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);

    }
}
