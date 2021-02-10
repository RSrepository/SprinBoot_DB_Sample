package com.r_saiki.springboot.domein.repository;

import java.util.List;
import com.r_saiki.springboot.domein.model.User;

import org.springframework.dao.DataAccessException;

public interface UserDao {
	// Userテーブルにデータを1件insert
    public int insertOne(User user) throws DataAccessException;

    // Userテーブルのデータを1件取得
    public User selectOne(String userId) throws DataAccessException;

    // Userテーブルの全データを取得
    public List<User> selectMany() throws DataAccessException;

    // Userテーブルを1件更新
    public int updateOne(User user) throws DataAccessException;

    // Userテーブルを1件削除
    public int deleteOne(String userId) throws DataAccessException;
}
