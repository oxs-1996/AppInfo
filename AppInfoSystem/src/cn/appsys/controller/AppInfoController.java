package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.istack.internal.logging.Logger;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.DataDictionaryService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppInfoController {

	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService; 
	@Resource
	private AppCategoryService appCategoryService;
	
	private Logger logger = Logger.getLogger(AppInfoController.class);
	
	@RequestMapping("/list")
	public String getAppInfoList(Model model,HttpSession session,
			@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
			@RequestParam(value="queryStatus",required=false) String _queryStatus,
			@RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
			@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
			@RequestParam(value="pageIndex",required=false) String pageIndex){
		logger.info("getAppInfoList------------>querySoftwareName:"+querySoftwareName);
		logger.info("getAppInfoList------------>queryStatus:"+_queryStatus);
		logger.info("getAppInfoList------------>queryCategoryLevel1:"+_queryCategoryLevel1);
		logger.info("getAppInfoList------------>queryCategoryLevel2:"+_queryCategoryLevel2);
		logger.info("getAppInfoList------------>queryCategoryLevel3:"+_queryCategoryLevel3);
		logger.info("getAppInfoList------------>queryFlatformId:"+_queryFlatformId);
		logger.info("getAppInfoList------------>pageIndex:"+pageIndex);
		
		Integer devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;
		List<AppCategory> categoryLevel2List = null;
		List<AppCategory> categoryLevel3List = null;
		
		Integer pageSize = Constants.pageSize;
		Integer currentPageNo = 1;
		if(pageIndex!=null){
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		Integer queryStatus = null;
		if(_queryStatus != null && !("").equals(_queryStatus)){
			queryStatus = Integer.parseInt(_queryStatus);
		}
		
		Integer queryCategoryLevel1 = null;
		if(_queryCategoryLevel1 != null && !("").equals(_queryCategoryLevel1)){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
		}
		
		Integer queryCategoryLevel2 = null;
		if(_queryCategoryLevel2 != null && !("").equals(_queryCategoryLevel2)){
			queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
		}
		
		Integer queryCategoryLevel3 = null;
		if(_queryCategoryLevel1 != null && !("").equals(_queryCategoryLevel1)){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
		};
		
		Integer queryFlatformId = null;
		if(_queryFlatformId != null && !("").equals(_queryFlatformId)){
			queryFlatformId = Integer.parseInt(_queryFlatformId);
		};
		
		//总页数
		Integer totalCount = appInfoService.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		
		PageSupport page = new PageSupport();
		page.setCurrentPageNo(currentPageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		Integer totalPageCount = page.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		appInfoList = appInfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
		statusList = this.getDataDictionaryList("APP_STATUS");
		flatFormList = this.getDataDictionaryList("APP_FLATFORM");
		categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("pages", page);
		model.addAttribute("queryStatus", queryStatus);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("queryFlatformId", queryFlatformId);
		
		
		return "developer/appinfolist";
	}
	
	public List<DataDictionary> getDataDictionaryList(String typeCode){
		List<DataDictionary> dataDictionaryList = null;
		dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
		return dataDictionaryList;
	}
	
	
	
}
