package com.arun.blue.dao;

import java.util.List;

import com.arun.blue.model.Comment;

public interface CommentDao 
{
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public Comment getComment(int id);
	public List<Comment> getCommentsonSinglePost(int id);
	public List<Comment> getCommentsonSingleTopic(int id);
	public void deleteComment(int id);
}
