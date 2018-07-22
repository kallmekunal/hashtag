package com.kunal.project.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kunal.project.db.UserInfo;
import com.kunal.project.domain.ExceptionJSONInfo;
import com.kunal.project.domain.User;
import com.kunal.project.exceptions.PersistenceException;
import com.kunal.project.service.UserInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private UserInfoService userInfoService;


	@Autowired(required=true)
	@Qualifier(value="userInfoService")
	public void setUserInfoService(UserInfoService us){
		this.userInfoService = us;
	}
	
	@Autowired
	@Qualifier("userInfoValidator")
	private Validator validator;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "welcome";
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String catalogLink(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Logged into catalogLink");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "catalog";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/processForm", method = RequestMethod.GET)
	public ModelAndView processForm(HttpServletRequest request, Model model) {
		logger.info("Logged into processForm"+request.getParameter("name"));
		User user = new User();
		user.setUsername(request.getParameter("name"));
		user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
		 model.addAttribute("userinfo", user); 
		ModelAndView modelAndView = new ModelAndView("addcustomer", "command", user);
		return modelAndView;
	}

	@ModelAttribute("webFrameworkList")
	public List<String> getWebFrameworkList() {
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("Apache Wicket");
		return webFrameworkList;
	}

	
	@InitBinder("userinfo")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }
	
	@ModelAttribute("user")
	public User createUserModel() {
		return new User();
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userinfo") @Valid User user, 
			BindingResult bindingResult,ModelMap model) throws Exception {
		if(bindingResult.hasErrors()){
			logger.info("Validation Error occured field-Name:"+ bindingResult.getFieldError().getField());
//			model.
			ModelAndView modelAndView = new ModelAndView("addcustomer", "command", user);
			//ModelAndView modelAndView = new ModelAndView("SpringWeb");
			return modelAndView;
			
		}
		model.addAttribute("username", user.getUsername());
		model.addAttribute("age", user.getAge());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("receivePaper", user.isReceivePaper());
		model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
		UserInfo mappedUserInfo = new UserInfo();
		mappedUserInfo.setAddress(user.getAddress());
		mappedUserInfo.setAge(user.getAge());
		mappedUserInfo.setFrameworks(user.getFavoriteFrameworks()[0]);
		mappedUserInfo.setSubnewsletter(user.isReceivePaper());
		mappedUserInfo.setUsername(user.getUsername());
		if("kunal".equalsIgnoreCase(user.getUsername())) {
			throw new PersistenceException("Kunal");
		}
		if("kunal1".equalsIgnoreCase(user.getUsername())) {
			throw new Exception("Kunal");
		}
		userInfoService.addUserInfo(mappedUserInfo);
		ModelAndView modelAndView = new ModelAndView("users", "command", user);
		return modelAndView;
//		return "users";
	}

	/*@ExceptionHandler(PersistenceException.class)
	public ModelAndView persistanceException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());

		modelAndView.setViewName("error");
		return modelAndView;
	}	*/

	
	
	@ExceptionHandler(PersistenceException.class)
	public @ResponseBody ExceptionJSONInfo persistanceException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);

		/*ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());

		modelAndView.setViewName("error");
		return modelAndView;
		
		*/
		
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		
		return response;
	}	
}
