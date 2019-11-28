package cn.appsys.dao;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserDao {

	/**
	 * 根据编码和密码获取指定开发用户的信息
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser getUserByCodeAndPwd(@Param("devCode") String devCode, 
									   @Param("devPassword") String devPassword);

}
