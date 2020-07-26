package jp.matrix.app.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.matrix.viewModel.UserViewModel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping(value={"signedup"})
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
	public ModelAndView change(@Validated @ModelAttribute UserViewModel form, BindingResult result, ModelAndView model)
	{
		if (result.hasErrors())
		{
			UserViewModel mo = new UserViewModel();
			mo.setUserId(form.getUserId());
			mo.setNewPassword("");
			mo.setRetryPassword("");
			log.info("has error: {}", result.getFieldError());
		}
		
		model.setViewName("signedup.html");
		model.addObject("userViewModel", form);
		
		return model;
	}
}
