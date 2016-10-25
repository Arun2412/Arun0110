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
import com.arun.blue.dao.PostDao;
import com.arun.blue.model.Client;
import com.arun.blue.model.Comment;
import com.arun.blue.model.Post;

@Controller
public class BlogController 
{
	@Autowired
	ClientDao clientDao;
	@Autowired
	PostDao postDao;
	@RequestMapping("/toAddPost")
	public ModelAndView disAddPostForm()
	{
		Post post = new Post();
		return new ModelAndView("AddPost","AddPostKey",post);
	}
	@RequestMapping("/toAddBlog")
	public String addPost(@ModelAttribute("AddPostKey") Post post,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		Date date = new Date();
		post.setPostAddedTime(date);
		post.setClient(client);
		postDao.addPost(post);
		Path path = Paths.get("E://collaboration all//collabworkspace1//blue//src//main//resources//images//Post"+post.getPostId()+".jpg");
		if(file != null && !file.isEmpty())
		{
			file.transferTo(new File(path.toString()));
		}
		return "redirect:/toViewPosts";
	}
	@RequestMapping("/toViewPosts")
	public ModelAndView disViewPost() throws JsonGenerationException, JsonMappingException, IOException
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		List<Post> list = postDao.getAllAddedByClient(client.getClientid());
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		ModelAndView modelAndView = new ModelAndView("Post");
		modelAndView.addObject("PostListKey",listJSON);
		modelAndView.addObject("CommentKey", new Comment());
		return modelAndView;
	}
	@RequestMapping("/toDeletePost")
	public String deletePost(@RequestParam("id") String str)
	{
		postDao.deletePost(Integer.parseInt(str));
		return "redirect:/toViewPosts";
	}
	@RequestMapping("/toEditPost")
	public ModelAndView editPost(@RequestParam("id") String str)
	{
		Post post = postDao.getPost(Integer.parseInt(str));
		return new ModelAndView("PostEdit","PostEditKey",post);
	}
	@RequestMapping("/toUpdatePost")
	public String disUpdatedPost(@ModelAttribute("PostEditKey") Post postUpdated,@RequestParam("file") MultipartFile pic) throws IllegalStateException, IOException
	{
		Date date = new Date();
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = clientDao.getClientByName(activeUserName);
		postUpdated.setPostAddedTime(date);
		postUpdated.setClient(client);
		postDao.updatePost(postUpdated);
		Path path = Paths.get("E://collaboration all//collabworkspace1//blue//src//main//resources//images//Post"+postUpdated.getPostId()+".jpg");
		if(pic != null && !pic.isEmpty())
		{
			pic.transferTo(new File(path.toString()));
		}
		return "redirect:/toViewPosts";
	}
}
