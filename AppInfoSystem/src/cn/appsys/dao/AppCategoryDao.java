package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryDao {
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId);
}
