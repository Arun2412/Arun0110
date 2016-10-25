package com.arun.blue.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.blue.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao
{
	@Autowired
	SessionFactory sessionFactory;
	public void addComment(Comment comment) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(comment);
		transaction.commit();
	}
	public void updateComment(Comment comment) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(comment);
		transaction.commit();
	}

	public Comment getComment(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Comment where id = '"+id+"'");
		Comment comment = (Comment) query.uniqueResult();
		return comment;
	}

	public List<Comment> getCommentsonSinglePost(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Comment where postId = '"+id+"'");
		List<Comment> list = query.list();
		return list;
	}

	public List<Comment> getCommentsonSingleTopic(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Comment where topicId = '"+id+"'");
		List<Comment> list = query.list();
		return list;
	}

	public void deleteComment(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Comment comment = session.get(Comment.class, new Integer(id));
		session.delete(comment);
		transaction.commit();
	}

}
