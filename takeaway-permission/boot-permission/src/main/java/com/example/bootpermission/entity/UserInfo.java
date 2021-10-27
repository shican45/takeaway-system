package com.example.bootpermission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: zhangyunfei
 * @date: 2021/5/16 23:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String account;
    private String password;
}