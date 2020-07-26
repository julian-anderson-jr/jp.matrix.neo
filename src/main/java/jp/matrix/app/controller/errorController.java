package jp.matrix.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class errorController {
	@RequestMapping(value="/error2", method=RequestMethod.GET)
	public String index()
	{
		return "error.html";
	}
}
