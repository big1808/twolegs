package com.tedu.util;

import java.util.UUID;

public class UUIDUtil {
   //获取uuid
	public static String getUUIDUtil(){
		String uuid=UUID.randomUUID().toString();
		return uuid;
	}
}
