package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * 根据条件模糊查询app信息
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<AppInfo> getAppInfoList(String querySoftwareName,Integer queryStatus,
										Integer queryCategoryLevel1,Integer queryCategoryLevel2,
										Integer queryCategoryLevel3,Integer queryFlatformId,
										Integer devId,Integer currentPageNo,Integer pageSize);
	
	/**
	 * 获取根据条件模糊查询的app信息的记录数
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 */
	public Integer getAppInfoCount(String querySoftwareName,Integer queryStatus,
								   Integer queryCategoryLevel1,Integer queryCategoryLevel2,
								   Integer queryCategoryLevel3,Integer queryFlatformId,
								   Integer devId);
	
	public List<AppInfo> getAppInfo();
	
	
	
	}