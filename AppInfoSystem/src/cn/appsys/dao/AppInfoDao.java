package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfoDao {
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
	public List<AppInfo> getAppInfoList(@Param("softwareName") String querySoftwareName,
										@Param("status") Integer queryStatus,
										@Param("categoryLevel1") Integer queryCategoryLevel1,
										@Param("categoryLevel2") Integer queryCategoryLevel2,
										@Param("categoryLevel3") Integer queryCategoryLevel3,
										@Param("flatformId") Integer queryFlatformId,
										@Param("devId") Integer devId,
										@Param("from") Integer currentPageNo,
										@Param("pageSize") Integer pageSize);
	
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
	public Integer getAppInfoCount(@Param("softwareName") String querySoftwareName,
								   @Param("status") Integer queryStatus,
								   @Param("categoryLevel1") Integer queryCategoryLevel1,
								   @Param("categoryLevel2") Integer queryCategoryLevel2,
								   @Param("categoryLevel3") Integer queryCategoryLevel3,
								   @Param("flatformId") Integer queryFlatformId,
								   @Param("devId") Integer devId);
	
	
	public List<AppInfo> getAppInfo();
	
}
