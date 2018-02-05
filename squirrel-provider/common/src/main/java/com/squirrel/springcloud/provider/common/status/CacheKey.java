package com.squirrel.springcloud.provider.common.status;

/**
 * 缓存 统一key值 统一cacheName值
 * 
 * @author JoinHan on 2017/04/25
 */
public class CacheKey {
	/*
	 * cacheName值
	 */
	// 系统缓存
	public static final String SYS_CACHE = "SysCache";
	// 缓存用户信息
	public static final String USER_CACHE = "UserCache";

	/*
	 * key 值
	 */
	// 系统 用户信息key
	public static final String SYS_USER = "userInfo";

	// -------- 其他缓存
	
}
