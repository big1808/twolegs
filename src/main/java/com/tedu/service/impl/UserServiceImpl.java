package com.tedu.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tedu.dao.UserDao;
import com.tedu.entity.User;
import com.tedu.service.UserService;
import com.tedu.vo.Result;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;	
	@Override
	public Result getUserInfo(String userId) {
		Result result=new Result();
		User user=new User();
		user=userDao.getUser(userId);
		Map<String, String> photoMap=new HashMap<>();
		//获取用户 相册存放的目录,将目录中的picture以map的形式存储
		String pathname=user.getPhoto();
		File photoPath=new File(pathname);
		if (photoPath.exists()) {
			//遍历目录中的文件
			File[] files=photoPath.listFiles();
			for (File file : files) {
				//获取图片地址
				String pathStr=file.getPath();
				//获取图片ID
				String photoId=file.getName();
				photoId=photoId.substring(0, photoId.lastIndexOf("."));
				photoMap.put(photoId, pathStr);
			}
		}
		if (!photoMap.isEmpty()) {
			result.setMap(photoMap);
		}
		result.setStatus(1);
		result.setMessage("success");
		result.setData(user);
		return result;
	}

}
