package cn.appsys.service;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
	/**
	 * 后台管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser backendlogin(String userCode,String userPassword);
	
}
