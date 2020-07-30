package jp.matrix.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.matrix.app.AppConfig;
import jp.matrix.service.UserRepository;
import jp.matrix.service.UserService;
import jp.matrix.viewModel.UserViewModel;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value={"/login"})
@Slf4j
public class loginController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(Model mv)
	{
		UserViewModel mo = new UserViewModel();
		mo.setUserId("");
		mo.setNewPassword("");
		mo.setRetryPassword("");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.html");
		mav.addObject("userViewModel", mo);
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView change(@Validated @ModelAttribute UserViewModel form, BindingResult result, ModelAndView model, HttpServletRequest request) throws Throwable
	{
		model.addObject("userViewModel", form);
		if (result.hasErrors())
		{
			model.setViewName("login.html");
			return model;
		}
		if (Strings.isNotBlank(form.getNewPassword()) )
		{
			ApplicationContext context = (ApplicationContext)new AnnotationConfigApplicationContext(AppConfig.class);
			BCryptPasswordEncoder enc = context.getBean("passwordEncoder", BCryptPasswordEncoder.class);
			User user = new User();
			user.setName(form.getUserId());
			user.setPassword(enc.encode(form.getNewPassword()));
			UserService uservice = context.getBean("userService", UserService.class);
			int rs = uservice.auth(user);
			if (rs == 0)
			{
				//success
				form.setMsg("ログイン成功");
			}
			log.debug("CREATE USER:" + form.getUserId());
		}
		model.addObject("userViewModel", form);
		model.setViewName("login.html");
		
		return model;
	}
	

}
