package com.r_saiki.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r_saiki.springboot.domein.model.User;
import com.r_saiki.springboot.domein.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 一件追加用メソッド
	@RequestMapping("/insert")
	public String insert(User user) {
		String result = "";
		if (userService.insert(user))
			result = "一件追加しました！";
		else
			result = "追加失敗しました！";
		return result;
	}

	// 全件取得用メソッド
	@RequestMapping("/selectMany")
	public List<User> selectMany() {
		// 全件取得
		return userService.selectMany();
	}

	// 1件取得用メソッド
	@RequestMapping("/selectOne")
	public User selectOne(String userId) {
		// selectOne実行
		return userService.selectOne(userId);
	}

	// 1件更新メソッド
	@RequestMapping("/updateOne")
	public String updateOne(User user) {
		String result = "";
		if (userService.updateOne(user))
			result = "一件更新しました！";
		else
			result = "更新失敗しました！";
		return result;
	}

	// 1件削除メソッド
	@RequestMapping("/deleteOne")
	public String deleteOne(String userId) {
		String result = "";
		if (userService.deleteOne(userId))
			result = "一件削除しました！";
		else
			result = "削除しました！";
		return result;
	}
}