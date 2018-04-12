package com.xyz.ata.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.bean.ProfileBean;
import com.xyz.ata.util.User;

@Controller
@SessionAttributes("loginName")


public class UtilityController {
	@Autowired
	User user;
private static boolean visitCount=false;
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public ModelAndView showLogin(
			@ModelAttribute("credential")CredentialsBean credentialsBean,
			BindingResult result,Model model) {
		if(visitCount==true)
		{
			model.addAttribute("error","invalidcredentials");
			visitCount=false;
		}
		return new ModelAndView("userlogin");
	}
	@RequestMapping(value = "/logo", method = RequestMethod.GET)
	public ModelAndView showLogo() {
		
		return new ModelAndView("logo");
	}
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView showAboutUs() {
		
		return new ModelAndView("aboutus");
	}
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView showContactUs() {
		
		return new ModelAndView("contactus");
	}
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView showChangePassword() {
		
		return new ModelAndView("changepassword","credentials",new CredentialsBean());
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLogout(HttpSession httpSession) {
		
		user.logout((String) httpSession.getAttribute("loginName"));
		httpSession.invalidate();
		return "logout";
	}
	@RequestMapping(value = "/title", method = RequestMethod.GET)
	public ModelAndView showTitle() {
		
		return new ModelAndView("title");
	}
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView showInfo() {
		
		return new ModelAndView("info");
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView showAbout() {
		
		return new ModelAndView("about");
	}
	@RequestMapping(value = "/copyright", method = RequestMethod.GET)
	public ModelAndView showCopyright() {
		
		return new ModelAndView("copyright");
	}
	@RequestMapping(value = "/TravelsHome", method = RequestMethod.GET)
	public ModelAndView showTravelsHome() {
		
		return new ModelAndView("TravelsHome");
	}
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView showError() {
		
		return new ModelAndView("error");
	}
	
	@RequestMapping( value="/changepassword",method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("credentials")CredentialsBean cBean,
		Model model,HttpSession session) {
		String userID=(String) session.getAttribute("loginName");
		cBean.setUserID(userID);
		String passwordStatus=user.changePassword(cBean, cBean.getNewPassword());
		if("CHANGED".equals(passwordStatus))
		{
			model.addAttribute("message","Password Changed");
		}
		return "logout";
	}
	
	@RequestMapping( value="/login",method=RequestMethod.POST)
	public String userLogin(@ModelAttribute("credential")CredentialsBean cBean,
		Model model) {
		String userType = user.login(cBean);
		
		if ("A".equals(userType)) {
			model.addAttribute("loginName",cBean.getUserID());
			
			return ("adminhome");
		} else if ("C".equals(userType)) {
			model.addAttribute("loginName",cBean.getUserID());
			
			
			return ("customerhome");
		} else if ("FAIL".equals(userType)){
			model.addAttribute("error","ID not existing");
			model.addAttribute("register",new ProfileBean());
			return ("register");
		}
		else
		{
			model.addAttribute("error","invalidcredentials");
			visitCount=true;
			return ("TravelsHome");
		}
		
		
	}

}
