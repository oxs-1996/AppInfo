package cn.appsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.BackendUserDao;
import cn.appsys.pojo.BackendUser;

@Service
public class BackendUserServiceImpl implements BackendUserService {

	@Resource
	private BackendUserDao backendUserDao;

	/**
	 * 后台管理员登录
	 */
	@Override
	public BackendUser backendlogin(String userCode, String userPassword) {
		return backendUserDao.getBKUserByCodeAndPwd(userCode, userPassword);
	}
	
	
	
}
