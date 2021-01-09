package com.liutao.consumertwo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/7/16
 */
@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @Autowired
    public MainService mainService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用 restTemplate 集成 ribbon 做的负载均衡
     *
     * @return 提供服务的端口号
     */
    @GetMapping("hi")
    public String hi() {
        String providerHi = mainService.hi();
        return "ConsumerServer Port: " + port + "  ->>  ProviderServer return: " +   providerHi;
    }

    /**
     * 使用 restTemplate 集成 ribbon 做的负载均衡
     *
     * @return 提供服务的端口号
     */
    @GetMapping("hello")
    public String hello() {
        String url = "http://ProviderServer/hi";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }

    /**
     * 使用 loadBalancerClient.choose 做的负载均衡
     *
     * @return 提供服务的端口号
     */
    @GetMapping("choose")
    public String choose() {
//        方法一
//        List<ServiceInstance> providerServerList = discoveryClient.getInstances("ProviderServer");
//        ServiceInstance serviceInstance = providerServerList.get(new Random().nextInt(providerServerList.size()));
//        方法二
        ServiceInstance providerServer = loadBalancerClient.choose("ProviderServer");

        String url = "http://" + providerServer.getHost() + ":" + providerServer.getPort() + "/hi";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }

    /**
     * 使用 restTemplate 集成 ribbon 做的负载均衡
     *
     * @return 提供服务的端口号
     */
    @GetMapping("getMap")
    public String getMap() {
        String url = "http://ProviderServer/getMap?name={name}";
        Map<String, String> map = Collections.singletonMap("name", "liutaozhenbang");
        ResponseEntity<Person> forEntity = restTemplate.getForEntity(url, Person.class, map);
        return ToStringBuilder.reflectionToString(forEntity.getBody());
    }

    /**
     * 使用 restTemplate 集成 ribbon 做的负载均衡
     *
     * @return 提供服务的端口号
     */
    @GetMapping("postLocation")
    public void postLocation(HttpServletResponse response) throws IOException {
        String url = "http://ProviderServer/postLocation";
        Map<String, String> map = Collections.singletonMap("name", "memeda");

        URI uri = restTemplate.postForLocation(url, map, String.class);
        response.sendRedirect(uri.toURL().toString());

    }

    @GetMapping("getTestReget")
    public String getTestReget() {
        return mainService.getTestReget();
    }

    @GetMapping("postTest")
    public Map postTest() {
        Map<String, Object> liutao = Collections.singletonMap("liutao", 18);
        Map map = mainService.postTest(liutao);
        return map;
    }
}
