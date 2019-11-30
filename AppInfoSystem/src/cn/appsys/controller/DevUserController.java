package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sun.istack.internal.logging.Logger;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping("/dev")
public class DevUserController {
	private Logger logger = Logger.getLogger(DevUserController.class);
	@Resource
    private DevUserService devUserService;
	@Resource
	private AppInfoService appInfoService;
	
	/**
	 * 去开发者登录页面
	 * @return
	 */
	@RequestMapping("/devloginbefore")
	public String gotoLogin(){
		logger.info("-------------(去)后台管理登录页面-------------");
		return "devlogin";
	}
	
	/**
	 * 开发者登录
	 * @param devCode
	 * @param devPassword
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/devlogin")
	public String devlogin(String devCode,String devPassword,HttpSession session,Model model){
		logger.info("-----------开发者(登录)-----------");
		DevUser devUser = devUserService.devlogin(devCode, devPassword);
		if(devUser!=null){
			session.setAttribute(Constants.DEV_USER_SESSION, devUser);
			return "developer/main";
		}else{
			model.addAttribute("error", "登录失败，用户名或密码错误，请重新登录！");
			return "devlogin";
		}
	}
	
	/**
	 * 开发者注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		logger.info("-------------开发者(注销)------------");
		//使session失效
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping("/flatform/app/lists")
	public String list(Model model){
		logger.info("--------------(获取)所有App信息---------------");
		logger.info("getAppInfo--------->size:"+appInfoService.getAppInfo().size());
		model.addAttribute("appInfoList",appInfoService.getAppInfo());
		
		return "developer/appinfolist";
	}
	
	
	
	
	
	
	
}
