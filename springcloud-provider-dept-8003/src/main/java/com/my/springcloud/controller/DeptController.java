package com.my.springcloud.controller;

import com.my.springcloud.pojo.Dept;
import com.my.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/dept")
@Validated
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery(){
        // 获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("services->" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance: instances) {
            System.out.println(instance.getHost() + "\t" +instance.getPort() + instance.getUri());
        }

        return this.discoveryClient;
    }
}
