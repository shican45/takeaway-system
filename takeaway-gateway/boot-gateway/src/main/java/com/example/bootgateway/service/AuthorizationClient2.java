package com.example.bootgateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: hsc
 * @date: 2021/10/27 10:47
 */
@FeignClient(value = "auth-service")
public interface AuthorizationClient2  {

    @RequestMapping(value = "/verifytoken", method = RequestMethod.POST)
    String verifyToken(@RequestParam String token);

}