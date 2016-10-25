package com.arun.blue.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arun.blue.dao.ClientDao;
import com.arun.blue.model.Client;

@Controller
public class ProfileController 
{
	@Autowired
	ClientDao clientDao;
	@RequestMapping("/toEditProfile")
	public ModelAndView disEditProfile(@RequestParam("id") String clientid)
	{
		Client client = clientDao.getOneClient(Integer.parseInt(clientid));
		ModelAndView modelAndView = new ModelAndView("ProfileEdit");
		modelAndView.addObject("ClientEditKey",client);
		/*Client newClient = new Client();
		modelAndView.addObject("NewClientKey", newClient);*/
		return modelAndView;
	}
	@RequestMapping("/toUpdateProfile")
	public String disUpdateProfile(@ModelAttribute("ClientEditKey") Client clientUpdated,@RequestParam("file") MultipartFile pic) throws IllegalStateException, IOException
	{
		System.out.println("image after");
		clientDao.updateClient(clientUpdated);
		System.out.println("update client after");
		Path path = Paths.get("E://collaboration all//collabworkspace1//blue//src//main//resources//images//Client"+clientUpdated.getClientid()+".jpg");
		System.out.println("before if condition");
		if(pic != null && !pic.isEmpty())
		{
			pic.transferTo(new File(path.toString()));
		}
		System.out.println("after if condition");
		return "redirect:/toViewProfile";
	}
	@RequestMapping("/toViewProfile")
	public ModelAndView disEditedProfile(Principal principal)
	{
		String name = principal.getName();
		Client client = clientDao.getClientByName(name);
		return new ModelAndView("Profile","ClientKey",client);
	}
}
