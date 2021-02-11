package com.r_saiki.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.r_saiki.springboot.domein.model.User;
import com.r_saiki.springboot.domein.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 一件追加用メソッド
	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
		String result = "";
		if (userService.insert(user))
			result = "一件追加しました！";
		else
			result = "追加失敗しました！";
		return result;
	}

	// 全件取得用メソッド
	@GetMapping("/selectMany")
	public List<User> selectMany() {
		// 全件取得
		return userService.selectMany();
	}

	// 1件取得用メソッド
	@GetMapping("/selectOne/{id:[0-9]+}")
	public User selectOne(@PathVariable("id") String userId) {
		// selectOne実行
		return userService.selectOne(userId);
	}

	// 1件更新メソッド
	@PostMapping("/updateOne")
	public String updateOne(@RequestBody User user) {
		String result = "";
		if (userService.updateOne(user))
			result = "一件更新しました！";
		else
			result = "更新失敗しました！";
		return result;
	}

	// 1件削除メソッド
	@PostMapping("/deleteOne/{id:.+}")
	public String deleteOne(@PathVariable("id") String userId) {
		String result = "";
		if (userService.deleteOne(userId))
			result = "一件削除しました！";
		else
			result = "削除しました！";
		return result;
	}
}
