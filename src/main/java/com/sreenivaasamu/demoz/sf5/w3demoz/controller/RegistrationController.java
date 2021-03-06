package com.sreenivaasamu.demoz.sf5.w3demoz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.User;
import com.sreenivaasamu.demoz.sf5.w3demoz.domain.UserDto;
import com.sreenivaasamu.demoz.sf5.w3demoz.service.EmailExistsException;
import com.sreenivaasamu.demoz.sf5.w3demoz.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}

	@RequestMapping(value = "/registrationsubmit", method = RequestMethod.POST)	
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result,
			WebRequest request, Errors errors) {
		User registered = new User();
		if (!result.hasErrors()) {
			registered = createUserAccount(accountDto, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return new ModelAndView("registration", "user", accountDto);
		} else {
			return new ModelAndView("successRegister", "user", accountDto);
		}
	}

	private User createUserAccount(UserDto accountDto, BindingResult result) {
		User registered = null;
		try {
			registered = userService.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
	}
}
