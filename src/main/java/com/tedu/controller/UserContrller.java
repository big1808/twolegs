package com.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.entity.User;
import com.tedu.service.UserService;
import com.tedu.vo.Result;

@RestController
@RequestMapping("user/")
public class UserContrller {
	@Autowired
	UserService userService;
	/**
	 * 用户信息详情页
	 * @param userId  用户ID
	 * @return  
	 */
	@RequestMapping(value="detailsInfo",method=RequestMethod.GET)
	@ResponseBody
	public Result detailsInfo(String userId) {
		Result result=new Result();
		
		result=userService.getUserInfo(userId);		
		
		return result;		
	}
}
