package com.r_saiki.springboot.domein.model;

import lombok.Data;

@Data
public class User {
    private int userId; // ユーザーID
    private String password; // パスワード
    private String userName; // ユーザー名
    private int age; // 年齢
    private String role; // ロール
}
