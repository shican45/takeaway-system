package com.example.bootpermission;

import com.alibaba.fastjson.JSON;
import com.example.bootpermission.entity.UserInfo;
import com.example.bootpermission.service.LoginService;
import com.example.permissioncommon.JWTUtils;
import domain.Merchant;
import domain.Rider;
import domain.User;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @description:
 * @author: hsc
 * @date: 2021/5/11 16:35
 */
@RestController()
@RequestMapping("permission")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger("AuthController");

    @Autowired
    LoginService loginService;

    @RequestMapping(value = {"/verifytoken"}, method = RequestMethod.POST)
    public ResponseEntity<String> verifyToken(@RequestParam String token) {
        return loginService.verifyToken(token);
    }

    @PostMapping("/userLogin")
    public Map<String, Object> userLogin(@RequestParam User user) {
        return loginService.userLogin(user);
    }

    @PostMapping("/riderLogin")
    public Map<String, Object> riderLogin(@RequestParam Rider rider) {
        return loginService.riderLogin(rider);
    }

    @PostMapping("/merchantLogin")
    public Map<String, Object> merchantLogin(@RequestParam Merchant merchant) {
        return loginService.merchantLogin(merchant);
    }


    @PostMapping("/userRegister")
    public Map<String, Object> userRegister(@RequestParam User user) {
        return loginService.userRegister(user);
    }

    @PostMapping("/riderRegister")
    public Map<String, Object> riderRegister(@RequestParam Rider rider) {
        return loginService.riderRegister(rider);
    }

    @PostMapping("/merchantRegister")
    public Map<String, Object> merchantRegister(@RequestParam Merchant merchant) {
        return loginService.merchantRegister(merchant);
    }
    /**
     * 鉴权: 通过token 获得用户的信息。
     * - 成功：返回用户信息
     * - 失败：返回 401
     * - 失败的情形： 1、token 过期。2、token 为空或无效。
     *
     * @param token
     * @return
     */
    @RequestMapping(value = {"/authority"}, method = RequestMethod.POST)
    public String authority(@RequestParam String role, @RequestParam String token, @RequestParam String resource) {
        logger.info("## permission" + token);
        return "{ userId:123, userName:\"zhang3\" }";
    }


    /**
     * 根据token 获得我的个人信息
     *
     * @param token
     * @param resource
     * @return
     */
    @RequestMapping(value = "/mine", method = RequestMethod.POST)
    public String mine(@RequestParam String token, @RequestParam String resource) {
        logger.info("## permission" + token);
        return "{ userId:123, userName:\"zhang3\", group:\"zh\", country:\"china\" }";
    }

    /**
     * 身份认证：即 通过账户密码获得 token
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = {"/authorization", "/login"})
    public String authorization(@RequestParam String account, @RequestParam String password) {
        String token = JWTUtils.createJwt(account, password);
        logger.info("## authorization name={}, token={}", account, token);
        return token;

    }
}