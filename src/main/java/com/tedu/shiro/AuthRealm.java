package com.tedu.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.tedu.dao.UserMapper;
import com.tedu.entity.User;


public class AuthRealm extends AuthorizingRealm{
	@Resource(name="userMapper")
	private UserMapper userMapper;
	//权限认证的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//得到用户对象
		Subject subject=SecurityUtils.getSubject();
		String nickName=subject.getSession().getAttribute("nickName").toString();
		//通过用户名查询用户角色信息
		List<String> moduleList=this.userMapper.findModuleByTeduName(nickName);
	    //创建授权管理
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
	    //传入授权管理的集合信息
		info.addStringPermissions(moduleList);
		return info;
	}
    //登录认证的方法，由安全管理中心回调此方法，去realm数据库获取真实数据
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken loginToken=(UsernamePasswordToken) token;
		String nickName = loginToken.getUsername();
		User user=this.userMapper.findUserByNickname(nickName);
		AuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassWord(),this.getName());
		return info;
	}
	
}
