package com.tedu.service.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.dao.UserMapper;
import com.tedu.entity.User;
import com.tedu.service.UserService;
import com.tedu.util.CommonValue;
import com.tedu.util.MD5Util;
import com.tedu.util.UUIDUtil;
import com.tedu.util.UploadUtil;
import com.tedu.vo.Result;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Override
	public Result addUser(User user,MultipartFile picture,HttpServletRequest request) {
	    Result result=new Result();
	    String originalFilename="";
		//获取head文件路径
		String realPath=request.getServletContext().getRealPath("/static/head");
		//如果文件夹不存在就创建这个文件夹
		File file=new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		//获取uuid
		String uuid=UUIDUtil.getUUIDUtil();
		//给user设置user_id;
		user.setId(uuid);
		//判断用户是否上传了头像
		if(picture==null||picture.isEmpty()) {
			user.setHead("default.png");
		}else{
			//原始文件名
			originalFilename= picture.getOriginalFilename();
			//原始文件类型
			String contentType = picture.getContentType();
			//原始文件尺寸
			long size = picture.getSize();
			if(!CommonValue.contentTypes.contains(contentType)){
				result.setStatus(0);
				result.setMessage("请上传图片格式的头像！");
				return result;
			}
			if(size>4*1024*1024){
				result.setStatus(0);
				result.setMessage("头像所占内存过大！");
				return result;
			}
			//给图片缩放和添加水印
			boolean flag = UploadUtil.uploadImage(picture, uuid, false, 64, realPath);
			if(!flag){
				result.setStatus(0);
				result.setMessage("服务器异常！头像上传不成功！请重试！");
				return result;
			}
			String substring = originalFilename.substring(originalFilename.lastIndexOf('.')+1);
			String fileName=uuid+substring;
			user.setHead(fileName);
		}
	    //给user设置MD5加密的密码
	    if(user.getPassWord()!=null)
	    user.setPassWord(MD5Util.md5(user.getPassWord()));
	    //给user设置图片集路径
	    //获取图片集路径
	    String path1="/static/photos";
	    String photosPath=request.getServletContext().getRealPath(path1);
	    String Path=path1+"/"+uuid;
	    photosPath=request.getServletContext().getRealPath(Path);
	    File photoFile=new File(photosPath); 
	    if(!photoFile.exists()) {
	        photoFile.mkdirs();
	    }
	    //设置用户点赞数初始值为0
	    user.setLike(0);
	    //设置用户展现量初始值为0
	    user.setPv(0);
	    //set的是每个用户的uuid的路径
	    user.setPhoto(photosPath);
		userMapper.addUser(user);
		result.setStatus(1);
		result.setMessage("添加用户成功");
		return result;
	}
	@Override
	public Result findUser(User user) {
		Result result=new Result();
		user=userMapper.findUser(user);
		if(user!=null) {
			result.setStatus(1);
			result.setData(user);
			result.setMessage("用户信息已查到");
		}else{
			result.setMessage("用户不存在");
			result.setStatus(1);
		}
		return result;
	}

	@Override
	public Result updateUser(User user) {
		user.setPassWord(MD5Util.md5(user.getPassWord()));
		Result result = new Result();
		int i = this.userMapper.updateUser(user);
		if(i>0) {
			result.setStatus(1);
			result.setMessage("更新成功");
		}else {
			result.setStatus(0);
			result.setMessage("更新失败，请稍后重试");
		}
		
		return result;
	}
	@Override
	public Result deleteUser(User user) {
		Result result = new Result();
		int i = this.userMapper.deleteUser(user);
		if(i>0) {
			result.setStatus(1);
			result.setMessage("删除成功");
		}else {
			result.setStatus(0);
			result.setMessage("删除失败，请稍后重试");
		}
		return result;
	}
	@Override
	public Result login_shiro(String teduName, String passWord, HttpSession session) {
		Result result=new Result();
		
		//Subject suject=SecurityUtils
		
		return result;
	}
}
