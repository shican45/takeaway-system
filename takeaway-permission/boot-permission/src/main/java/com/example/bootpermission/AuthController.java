package com.example.bootpermission;

import com.alibaba.fastjson.JSON;
import com.example.bootpermission.entity.UserInfo;
import com.example.bootpermission.service.LoginService;
import com.example.permissioncommon.JWTUtils;
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
 * @author: zhangyunfei
 * @date: 2021/5/11 16:35
 */
@RestController()
@RequestMapping("permission")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger("AuthController");

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> user) {
        Map<String, Object> result = new HashMap<String, Object>();
        Boolean login = user.get("username").equals("test") && user.get("password").equals("1234");
        if (login) {
            Map<String, String> info = new HashMap<>(4);
            info.put("account", user.get("account"));
            String token = JWTUtils.createJwt(user.get("account"),
                    user.get("password"));
            info.put("token", token);
            result.put("200", "登录成功");
            result.put("info", info);
        } else {
            result.put("401", "用户名或密码错误");
        }
        return result;
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
    public String authority(@RequestParam String token, @RequestParam String resource) {
        logger.info("## permission" + token);
        return "{ userId:123, userName:\"zhang3\" }";
    }

    /**
     * 验证 token 的合法性
     *
     * @param token
     * @return
     */
    @RequestMapping(value = {"/verifytoken"}, method = RequestMethod.POST)
    public ResponseEntity<String> verifyToken(@RequestParam String token) {
        logger.info("## verifyToken 参数 token={}", token);
        Map<String, Object> claims = JWTUtils.parseJwt(token);
        String account = (String)claims.get("account");
        String password = (String)claims.get("password");
        if (claims.get("account") == null || account.isEmpty() || password.isEmpty() || password == null) {
            logger.info("## verifyToken 参数 token={}， 失败 ", token);
            return new ResponseEntity<>("internal error", HttpStatus.UNAUTHORIZED);
        }
        UserInfo user = new UserInfo(account, password);
        logger.info("## verifyToken 参数 token={}， 成功，用户信息={}", token, user);
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
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