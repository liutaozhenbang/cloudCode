package com.liutao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    //restTemplate 是无状态的 可以搞成单例的
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateInterceptor());

        return restTemplate;
    }


    //如果要修改ribbon的负载均衡策略  直接增加一个Bean标签把不同的负载均衡类返回就行不需要其他配置
    //还有一个更简单的做法直接改配置文件就可以了
//    @Bean
//    public IRule myRule() {
////        ribbon默认的负载均衡策略
////        return new RoundRobinRule();
////        return new RetryRule();
////        随机的负载均衡策略
//        return new RandomRule();
//
//    }
}
