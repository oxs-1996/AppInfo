package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppCategoryDao;
import cn.appsys.pojo.AppCategory;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryDao appCategoryDao;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) {
		return appCategoryDao.getAppCategoryListByParentId(parentId);
	}

}
