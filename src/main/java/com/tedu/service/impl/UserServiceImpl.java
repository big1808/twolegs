package com.tedu.service.impl;

import com.tedu.dao.UserDao;
import com.tedu.entity.User;
import com.tedu.service.UserService;
import com.tedu.vo.Result;

public class UserServiceImpl implements UserService {

	UserDao userDao;	
	@Override
	public Result getUserInfo(String userId) {
		User user=new User();
		user=userDao.getUser(userId);
		
		return null;
	}

}
