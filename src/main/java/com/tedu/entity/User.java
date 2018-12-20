package com.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = -8305427733971300997L;
	/*`user_id` CHAR(36) NOT NULL,                    用户id uuid 主键
	  `user_teduname` VARCHAR(100) NOT NULL,          用户登录达内用户名
	  `user_name`  VARCHAR(50),                   	  用户的昵称，系统内使用的用户名，相当于昵称
	  `user_password` VARCHAR(32) NOT NULL,           用户密码 登录密码
	  `user_head` VARCHAR(255) NOT NULL,              用户头像文件名包含全路径名,名称为uuid
	  `user_score` INT NOT NULL DEFAULT '0',          用户积分，默认：0
	  `user_status` TINYINT(1) NOT NULL DEFAULT '0',  用户是否注销(0表示没有注销，1表示注销)
	  `user_lock` TINYINT(1) NOT NULL DEFAULT '0',    用户是否锁定(0表示没有锁定，1表示锁定)
	  `user_regdate` TIMESTAMP DEFAULT NOW(),         用户注册日期(默认当前日期)
	  `user_age` INT DEFAULT '0',                     用户年龄 默认0
	  `user_like` INT  DEFAULT '0',                   用户点赞数
	  `user_sex` TINYINT(1) DEFAULT '0',              用户性别 0表示男，1表示女
	  `user_introduction` TEXT,                		  用户描述
	  `user_photo` VARCHAR(255),               		  用户相册目录
	  `user_birthday` DATE DEFAULT NULL,			 用户生日
	  `user_pv` INT(11) DEFAULT '0',  */   
	private String id;
	private String teduName;
	private String passWord;
	private String name;
	private String head;
	private int score;
	private int status;
	private int lock;
	private Timestamp regDate;
	private int age;
	private int like;
	private int sex;
	private String introduction;
	private String photo;
	private Date birthday;
	private int pv;
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTeduName() {
		return teduName;
	}



	public void setTeduName(String teduName) {
		this.teduName = teduName;
	}



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getHead() {
		return head;
	}



	public void setHead(String head) {
		this.head = head;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getLock() {
		return lock;
	}



	public void setLock(int lock) {
		this.lock = lock;
	}



	public Timestamp getRegDate() {
		return regDate;
	}



	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getLike() {
		return like;
	}



	public void setLike(int like) {
		this.like = like;
	}



	public int getSex() {
		return sex;
	}



	public void setSex(int sex) {
		this.sex = sex;
	}



	public String getIntroduction() {
		return introduction;
	}



	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public int getPv() {
		return pv;
	}



	public void setPv(int pv) {
		this.pv = pv;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", teduName=" + teduName + ", passWord=" + passWord + ", name=" + name + ", head="
				+ head + ", score=" + score + ", status=" + status + ", lock=" + lock + ", regDate=" + regDate
				+ ", age=" + age + ", like=" + like + ", sex=" + sex + ", introduction=" + introduction + ", photo="
				+ photo + ", birthday=" + birthday + ", pv=" + pv + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
