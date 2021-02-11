package com.r_saiki.springboot.domein.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.r_saiki.springboot.domein.repository.UserDao;
import com.r_saiki.springboot.domein.model.User;

@Repository("UserDaoJdbc")
public class UserDaoJdbc implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	// Userテーブルにデータを1件insert.
	@Override
	public int insertOne(User user) throws DataAccessException {
		// 1件登録
		int rowNumber = jdbc.update(
				"INSERT INTO m_user(user_id," + " password," + " user_name," + " age," + " role)"
						+ " VALUES(?, ?, ?, ?, ?)",
				user.getUserId(), user.getPassword(), user.getUserName(), user.getAge(), user.getRole());
		return rowNumber;
	}

	// Userテーブルのデータを1件取得
	@Override
	public User selectOne(String userId) throws DataAccessException {
		// 1件取得
		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_user" + " WHERE user_id = ?", userId);
		// 結果返却用の変数
		User user = new User();
		// 取得したデータを結果返却用の変数にセットしていく
		user.setUserId((Integer) map.get("user_id")); // ユーザーID
		user.setPassword((String) map.get("password")); // パスワード
		user.setUserName((String) map.get("user_name")); // ユーザー名
		user.setAge((Integer) map.get("age")); // 年齢
		user.setRole((String) map.get("role")); // ロール
		return user;
	}

	// Userテーブルの全データを取得
	@Override
	public List<User> selectMany() throws DataAccessException {
		// M_USERテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_user");
		// 結果返却用の変数
		List<User> userList = new ArrayList<>();
		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {
			// Userインスタンスの生成
			User user = new User();
			// Userインスタンスに取得したデータをセットする
			user.setUserId((Integer) map.get("user_id")); // ユーザーID
			user.setPassword((String) map.get("password")); // パスワード
			user.setUserName((String) map.get("user_name")); // ユーザー名
			user.setAge((Integer) map.get("age")); // 年齢
			user.setRole((String) map.get("role")); // ロール
			// 結果返却用のListに追加
			userList.add(user);
		}
		return userList;
	}

	// Userテーブルを1件更新.
	@Override
	public int updateOne(User user) throws DataAccessException {
		// 1件更新
		int rowNumber = jdbc.update(
				"UPDATE m_user" + " SET" + " password = ?," + " user_name = ?," + " age = ?" + " WHERE user_id = ?",
				user.getPassword(), user.getUserName(), user.getAge(), user.getUserId());
		return rowNumber;
	}

	// Userテーブルを1件削除
	@Override
	public int deleteOne(String userId) throws DataAccessException {
		// 1件削除
		int rowNumber = jdbc.update("DELETE FROM m_user WHERE user_id = ?", userId);
		return rowNumber;
	}
}
