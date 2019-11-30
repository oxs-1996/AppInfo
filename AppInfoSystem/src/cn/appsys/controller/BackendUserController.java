package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.istack.internal.logging.Logger;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.BackendUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping("/manager")
public class BackendUserController {

	private Logger logger = Logger.getLogger(BackendUserController.class);
	
	@Resource
	private BackendUserService backendUserService;
	@Resource
	private AppInfoService appInfoService;
	
	/**
	 * 去后台管理员登录页面
	 * @return
	 */
	@RequestMapping("/beloginbefore")
	public String beloginbefore(){
		logger.info("--------------(去)后台管理员登录页面---------------");
		return "backendlogin";
	}
	
	/**
	 * 后台管理员登录
	 * @param userCode
	 * @param userPassword
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/belogin")
	public String belogin(String userCode,String userPassword,Model model,HttpSession session){
		logger.info("----------------后台管理员(登录)------------------");
		BackendUser backendUser = backendUserService.backendlogin(userCode, userPassword);
		if(backendUser!=null){
			session.setAttribute(Constants.MGR_USER_SESSION, backendUser);
			return "backend/main";
		}else{
			model.addAttribute("error", "登录失败，用户名或密码错误，请重新登录！");
			return "backendlogin";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		logger.info("---------------(注销)后台管理员---------------");
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping("/backend/app/list")
	public String getAppInfo(Model model){
		logger.info("--------------(获取)所有App信息---------------");
		logger.info("getAppInfo--------->size:"+appInfoService.getAppInfo().size());
		model.addAttribute("appInfoList",appInfoService.getAppInfo());
		return "backend/applist";
	}
	
}
