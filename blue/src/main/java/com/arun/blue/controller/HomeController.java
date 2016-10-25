package com.arun.blue.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arun.blue.dao.ClientDao;
import com.arun.blue.model.Client;

@Controller
public class HomeController
{
	@Autowired
	ClientDao clientDao;

	@RequestMapping("/")
	public ModelAndView disHome() {
		Client client = new Client();
		ModelAndView modelAndView = new ModelAndView("HomePage");
		modelAndView.addObject("ClientKey", client);
		return modelAndView;
	}

	@RequestMapping("/toSignUp")
	public ModelAndView disRegistered(@Valid @ModelAttribute("ClientKey") Client client, BindingResult bindingResult) {
		/*
		 * if(bindingResult.hasErrors()) { return new ModelAndView("HomePage");
		 * }
		 */
		clientDao.addClient(client);
		return new ModelAndView("login", "message", "welcome " + client.getName() + ", you can login now");
	}

	@RequestMapping("/login")
	public ModelAndView toMain()
	{
		return new ModelAndView("login");
	}
	@RequestMapping("/toLogin")
	public ModelAndView disProfile(Principal principal)
	{
		String name = principal.getName();
		Client client = clientDao.getClientByName(name);
		return new ModelAndView("Profile","ClientKey",client);
	}
	@RequestMapping("/toViewFriends")
	public ModelAndView disFriendsList()
	{
		return new ModelAndView("FriendsList");
	}
	@RequestMapping("/toViewDiscussions")
	public ModelAndView disDiscussions()
	{
		return new ModelAndView("Topic");
	}
}
