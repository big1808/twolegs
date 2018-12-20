package com.tedu.service;

import org.springframework.context.annotation.ComponentScan;

import com.tedu.vo.Result;
@ComponentScan
public interface UserService {

	/**
	 * 获取用户详细信息进行展示
	 * @param userId
	 * @return
	 */
	Result getUserInfo(String userId);

}
