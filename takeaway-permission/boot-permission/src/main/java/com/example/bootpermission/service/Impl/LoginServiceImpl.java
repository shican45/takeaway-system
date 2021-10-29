package com.example.bootpermission.service.Impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bootpermission.entity.UserInfo;
import com.example.bootpermission.service.LoginService;
import com.example.permissioncommon.JWTUtils;
import domain.Merchant;
import domain.Rider;
import domain.User;
import domain.dao.MerchantDao;
import domain.dao.RiderDao;
import domain.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger("LoginServiceImpl");

    @Autowired
    UserDao userDao;

    @Autowired
    MerchantDao merchantDao;

    @Autowired
    RiderDao riderDao;

    @Override
    public ResponseEntity<String> verifyToken(@RequestParam String token) {
        logger.info("## verifyToken 参数 token={}", token);
        Map<String, Object> claims = JWTUtils.parseJwt(token);
        String account = (String) claims.get("account");
        String password = (String) claims.get("password");
        if (claims.get("account") == null || account.isEmpty() || password.isEmpty() || password == null) {
            logger.info("## verifyToken 参数 token={}， 失败 ", token);
            return new ResponseEntity<>("internal error", HttpStatus.UNAUTHORIZED);
        }
        UserInfo user = new UserInfo(account, password);
        logger.info("## verifyToken 参数 token={}， 成功，用户信息={}", token, user);
        return new ResponseEntity<>(JSON.toJSONString(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> userLogin(@RequestParam User user){


        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("account", user.getAccount());
        qw.like("password", user.getPassword());
        User findUser = userDao.selectOne(qw);

        if (user != null) {
            info.put("role: ", "user");
            info.put("account", findUser.getAccount());
            String token = JWTUtils.createJwt(user.getAccount(),
                    user.getPassword());
            info.put("token", token);
            response.put("code", 200);
            response.put("msg","登录成功");
            response.put("info", info);
        } else {
            response.put("401", "用户名或密码错误");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> riderLogin(@RequestParam Rider rider){


        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<Rider> qw = new QueryWrapper<>();
        qw.like("account", rider.getAccount());
        qw.like("password", rider.getPassword());
        Rider findRider = riderDao.selectOne(qw);

        if (rider != null) {
            info.put("role: ", "rider");
            info.put("account", findRider.getAccount());
            String token = JWTUtils.createJwt(rider.getAccount(),
                    rider.getPassword());
            info.put("token", token);
            response.put("code", 200);
            response.put("msg","登录成功");
            response.put("info", info);
        } else {
            response.put("401", "用户名或密码错误");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> merchantLogin(@RequestParam Merchant merchant){


        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<Merchant> qw = new QueryWrapper<>();
        qw.like("account", merchant.getAccount());
        qw.like("password", merchant.getPassword());
        Merchant findMerchant = merchantDao.selectOne(qw);

        if (findMerchant != null) {
            info.put("role: ", "merchant");
            info.put("account", findMerchant.getAccount());
            String token = JWTUtils.createJwt(merchant.getAccount(),
                    merchant.getPassword());
            info.put("token", token);
            response.put("code", 200);
            response.put("msg","登录成功");
            response.put("info", info);
        } else {
            response.put("401", "用户名或密码错误");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> userRegister(@RequestParam User user){
        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("account", user.getAccount());
        User findUser = userDao.selectOne(qw);

        if (user == null) {
            findUser.setAccount(user.getAccount());
            findUser.setPassword(user.getPassword());
            userDao.insert(findUser);
            info.put("account", user.getAccount());
            response.put("code", 200);
            response.put("msg","注册成功");
            response.put("info", info);
        } else {
            response.put("401", "账号已存在！");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> riderRegister(@RequestParam Rider rider){
        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<Rider> qw = new QueryWrapper<>();
        qw.like("account", rider.getAccount());
        Rider findRider = riderDao.selectOne(qw);

        if (rider == null) {
            findRider.setAccount(rider.getAccount());
            findRider.setPassword(rider.getPassword());
            riderDao.insert(findRider);
            info.put("account", rider.getAccount());
            response.put("code", 200);
            response.put("msg","注册成功");
            response.put("info", info);
        } else {
            response.put("401", "账号已存在！");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap> merchantRegister(@RequestParam Merchant merchant){
        HashMap<String, Object> response = new HashMap<>(8);
        HashMap<String, Object> info = new HashMap<>(8);

        QueryWrapper<Merchant> qw = new QueryWrapper<>();
        qw.like("account", merchant.getAccount());
        Merchant findMerchant = merchantDao.selectOne(qw);

        if (merchant == null) {
            findMerchant.setAccount(merchant.getAccount());
            findMerchant.setPassword(merchant.getPassword());
            merchantDao.insert(findMerchant);
            info.put("account", merchant.getAccount());
            response.put("code", 200);
            response.put("msg","注册成功");
            response.put("info", info);
        } else {
            response.put("401", "账号已存在！");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
