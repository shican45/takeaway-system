package com.example.bootpermission.service;

public interface LoginService {

    /**
     * 查询账号密码是否存在
     * @param account
     * @param password
     * @return true or false
     */
    Boolean login(String account, String password);
}
