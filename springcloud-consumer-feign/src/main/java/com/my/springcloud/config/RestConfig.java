package com.my.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    // 配置负载均衡实现RestTemplate
    // IRule
    // AvailabilityFilteringRule：会先过滤掉跳闸、访问故障的服务，对剩下的进行轮询
    // BestAvailableRule
    // ZoneAvoidanceRule
    // WeightedResponseTimeRule
    // ResponseTimeWeightedRule
    // RandomRule：随机
    // RetryRule：先轮询，若服务故障，在指定时间内重试
    // RoundRobinRule轮询（默认）
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
