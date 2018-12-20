package com.tedu.controller;
import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.entity.User;
import com.tedu.service.UserService;
import com.tedu.util.UUIDUtil;
import com.tedu.vo.Result;



@RestController
@RequestMapping("user/")
public class UserContrller {
    @Resource(name="userService")
	private UserService userService;
    /**
     * 用户增加用户的方法
     * @param user 封装的User类
     * @return result封装的结果类
     */
    @RequestMapping("addUser")
    @ResponseBody
	public Result addUser(User user,MultipartFile picture,HttpServletRequest request) {
		Result result=new Result();
	
		result=userService.addUser(user,picture,request);
		
		return result;
	}
    /**
     * 用户查找用户的方法
     * @param user 封装的User类
     * @return result封装的结果类
     */
    @RequestMapping("findUser")
    @ResponseBody
    public Result findUser(User user) {
    	Result result=new Result();
    	
    	result=userService.findUser(user);
    	
    	return result;
    }
    /**
     * 用户更新用户的方法
     * @param user 封装的User类
     * @return result封装的结果类
     */
	@RequestMapping("updateUser")
	public Result updateUser(User user) {
		Result result = new Result();
		
		result =this.userService.updateUser(user);
		
		return result;
	}
	/**
     * 用户删除用户的方法
     * @param user 封装的User类
     * @return result封装的结果类
     */
	@RequestMapping("deleteUser")
	public Result deleteUser(User user) {
		Result result=new Result();
		  
		result=this.userService.deleteUser(user);
		
		return result;
	}
	@RequestMapping("login")
	@ResponseBody
	public Result login_shiro(String teduName,String passWord,HttpSession session) {
		Result result=new Result();
		
		result=this.userService.login_shiro(teduName,passWord,session); 
		
		return result;
	}
    
}
