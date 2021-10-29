package com.example.bootpermission.service;

import domain.Merchant;
import domain.Rider;
import domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public interface LoginService {

    /**
     * 验证 token 的合法性
     *
     * @param token
     * @return ResponseEntity UserInfo + HttpStatus
     */
    ResponseEntity<String> verifyToken(@RequestParam String token);

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    ResponseEntity<HashMap> userLogin(@RequestParam User user);

    /**
     * 骑手登陆
     *
     * @param rider
     * @return
     */
    ResponseEntity<HashMap> riderLogin(@RequestParam Rider rider);

    /**
     * 商户登陆
     *
     * @param merchant
     * @return
     */
    ResponseEntity<HashMap> merchantLogin(@RequestParam Merchant merchant);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    ResponseEntity<HashMap> userRegister(@RequestParam User user);

    /**
     * 骑手注册
     *
     * @param rider
     * @return
     */
    ResponseEntity<HashMap> riderRegister(@RequestParam Rider rider);

    /**
     * 商户注册
     *
     * @param merchant
     * @return
     */
    ResponseEntity<HashMap> merchantRegister(@RequestParam Merchant merchant);
}
