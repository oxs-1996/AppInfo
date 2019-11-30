package cn.appsys.dao;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserDao {
	/**
	 * 根据用户编码和密码获取指定(后台)管理员
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser getBKUserByCodeAndPwd(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
	
}
