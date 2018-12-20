package com.tedu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.tedu.entity.User;
import com.tedu.vo.Result;

public interface UserService {
    //用于增加用戶的方法
	public Result addUser(User user, MultipartFile picture, HttpServletRequest request);
    //用于查找信息的方法
	public Result findUser(User user);
	//用于更新用户的操作
	public Result updateUser(User user);
	//用于删除用户的操作
	public Result deleteUser(User user);
	//用session管理用户登录权限
	public Result login_shiro(String teduName, String passWord, HttpSession session);

}
