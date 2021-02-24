package com.r_saiki.springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId; // ユーザーID
    @Column
    private String password; // パスワード
    @Column
    private String userName; // ユーザー名
    @Column
    private int age; // 年齢
    @Column
    private String role; // ロール
}
