package com.example.bootpermission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan({"com.example.bootpermission"})
public class BootPermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootPermissionApplication.class, args);
    }

}
