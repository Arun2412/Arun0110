package com.arun.blue.dao;

import java.util.List;

import com.arun.blue.model.Post;

public interface PostDao 
{
	public void addPost(Post post);
	public Post getPost(int id);
	public List<Post> getAllPosts();
	public void updatePost(Post post);
	public void deletePost(int id);
	public List<Post> getAllAddedByClient(int id);
}
