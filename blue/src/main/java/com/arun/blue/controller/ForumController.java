package com.arun.blue.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arun.blue.dao.ClientDao;
import com.arun.blue.dao.TopicDao;
import com.arun.blue.model.Client;
import com.arun.blue.model.Topic;

@Controller
public class ForumController
{
	@Autowired
	ClientDao clientDao;
	@Autowired
	TopicDao topicDao;
	@RequestMapping("/toAddTopic")
	public ModelAndView disAddTopicForm()
	{
		Topic topic = new Topic();
		return new ModelAndView("AddTopic","AddTopicKey",topic);
	}
	@RequestMapping("/toAddForum")
	public String addTopic(@ModelAttribute("AddTopicKey") Topic topic,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		Date date = new Date();
		topic.setTopicAddedTime(date);
		topic.setClient(client);
		topicDao.addTopic(topic);
		Path path = Paths.get("E://collaboration all//collabworkspace1//blue//src//main//resources//images//Topic"+topic.getTopicId()+".jpg");
		if(file != null && !file.isEmpty())
		{
			file.transferTo(new File(path.toString()));
		}
		return "redirect:/toViewTopics";
	}
	@RequestMapping("/toViewTopics")
	public ModelAndView disViewTopic() throws JsonGenerationException, JsonMappingException, IOException
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		List<Topic> list = topicDao.getAllAddedByClient(client.getClientid());
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		return new ModelAndView("Topic","TopicListKey",listJSON);
	}
	@RequestMapping("/toDeleteTopic")
	public String deleteTopic(@RequestParam("id") String str)
	{
		topicDao.deleteTopic(Integer.parseInt(str));
		return "redirect:/toViewTopics";
	}
	@RequestMapping("/toEditTopic")
	public ModelAndView editTopic(@RequestParam("id") String str)
	{
		Topic topic = topicDao.getTopic(Integer.parseInt(str));
		return new ModelAndView("TopicEdit","TopicEditKey",topic);
	}
	@RequestMapping("/toUpdateTopic")
	public String disUpdatedTopic(@ModelAttribute("TopicEditKey") Topic topicUpdated,@RequestParam("file") MultipartFile pic) throws IllegalStateException, IOException
	{
		Date date = new Date();
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		topicUpdated.setTopicAddedTime(date);
		topicUpdated.setClient(client);
		topicDao.updateTopic(topicUpdated);
		Path path = Paths.get("E://collaboration all//collabworkspace1//blue//src//main//resources//images//Topic"+topicUpdated.getTopicId()+".jpg");
		if(pic != null && !pic.isEmpty())
		{
			pic.transferTo(new File(path.toString()));
		}
		return "redirect:/toViewTopics";
	}

}
