package com.liutao.cloudadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAdminServer
public class CloudadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudadminApplication.class, args);
    }


    @Bean
    public DingDingNotifier dingdingNotifier(InstanceRepository repository) {
        return new DingDingNotifier(repository);
    }

}
