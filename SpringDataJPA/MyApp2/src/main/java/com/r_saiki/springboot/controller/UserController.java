package com.r_saiki.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.r_saiki.springboot.entity.User;
import com.r_saiki.springboot.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;

	// 全件取得用メソッド
	@GetMapping("/user/showUserList")
	@ResponseBody
	public List<User> showUserList() {
		return repository.findAll();
	}

	// 1件取得用メソッド
	@GetMapping("/user/{id:[0-9]+}")
	@ResponseBody
	public User showUser(@PathVariable("id") int userId) {
		return repository.getOne(userId);
	}
	
    // 1件追加用メソッド
    @PostMapping("/user/insertOne")
    public String insertOne(@RequestBody User user) {
    	repository.save(user);
        return "一件追加しました！";
    }
    
    // 1件更新メソッド
    @PostMapping("/user/updateOne")
    public String updateOne(@RequestBody User user) {
       	repository.save(user);
        return "一件更新しました！";
    }

    // 1件削除メソッド
    @PostMapping("/user/deleteOne/{id:.+}")
    public String deleteOne(@PathVariable("id") int userId) {
      	repository.deleteById(userId);
        return "一件削除しました！";
    }
}
