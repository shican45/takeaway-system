package com.example.bootpermission.service.Impl;


public class LoginServiceImpl {

    Boolean login(String account, String password){
        User userCondition = new User();
        userCondition.setLastAccount(account);
        userCondition.setLastPassword(password);
        User user = userDao.selectOne(employeeCondition);
        return
    }
}
