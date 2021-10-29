package com.example.bootgateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "takeaway-permission")
public interface AuthorizationClient2  {

    @RequestMapping(value = "/verifytoken", method = RequestMethod.POST)
    String verifyToken(@RequestParam String token);

}