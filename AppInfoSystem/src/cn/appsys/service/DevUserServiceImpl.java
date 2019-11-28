package cn.appsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserDao;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserDao devUserDao;

	/**
	 * 后台管理员登录
	 */
	@Override
	public DevUser devlogin(String devCode, String devPassword) {
		return devUserDao.getUserByCodeAndPwd(devCode, devPassword);
	}
	
	
	
}
