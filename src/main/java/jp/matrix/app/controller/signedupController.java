package jp.matrix.app.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;


import jp.matrix.app.AppConfig;
import jp.matrix.service.UserRepository;
import jp.matrix.viewModel.UserViewModel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping(value={"/signedup"})
@Slf4j
public class signedupController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(Model mv)
	{
		UserViewModel mo = new UserViewModel();
		mo.setUserId("");
		mo.setNewPassword("");
		mo.setRetryPassword("");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signedup.html");
		mav.addObject("userViewModel", mo);
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView change(@Validated @ModelAttribute UserViewModel form, BindingResult result, ModelAndView model, HttpServletRequest request)
	{
		model.addObject("userViewModel", form);
		if (result.hasErrors())
		{
			model.setViewName("signedup.html");
			return model;
		}
		if (Strings.isNotBlank(form.getNewPassword()) 
				&& Strings.isNotBlank(form.getRetryPassword())
				&& form.getNewPassword().equals(form.getRetryPassword()))
		{
			ApplicationContext context = (ApplicationContext)new AnnotationConfigApplicationContext(AppConfig.class);
			UserRepository us = context.getBean("userRespository", UserRepository.class);
			BCryptPasswordEncoder enc = context.getBean("passwordEncoder", BCryptPasswordEncoder.class);
			User user = new User();
			user.setName(form.getUserId());
			user.setPassword(enc.encode(form.getNewPassword()));
			int cnt = us.countByUsername(user.getName());
			if (cnt> 0 || cnt < 0)
			{
				form.setMsg("登録済みのため、登録できません。");
				model.addObject("userViewModel", form);
				model.setViewName("signedup.html");
				return model;
			}
			us.save(user);
			log.debug("CREATE USER:" + form.getUserId());
		}
		else
		{
			form.setMsg("パスワードが一致していません。");
			model.addObject("userViewModel", form);
			model.setViewName("signedup.html");
			return model;
		}
		model.addObject("userViewModel", form);
		//model.setViewName("redirect:/signedup/result");
		model.setViewName("signresult.html");
		
		return model;
	}
	
}
