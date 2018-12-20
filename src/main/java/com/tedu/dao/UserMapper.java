package com.tedu.dao;

import java.util.List;

import com.tedu.entity.User;

public interface UserMapper {
	public int updateUser(User user);

	public int deleteUser(User user);

	public void addUser(User user);

	public User findUser(User user);

	public List<String> findModuleByTeduName(String teduName);

	public User findUserByNickname(String nickName);


}
