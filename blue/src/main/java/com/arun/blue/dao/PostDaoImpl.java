package com.arun.blue.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.arun.blue.model.Post;

@Repository
public class PostDaoImpl implements PostDao
{
	@Autowired
	SessionFactory sessionFactory;
	public void addPost(Post post)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(post);
		transaction.commit();
	}

	public Post getPost(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Post where id = '"+id+"'");
		Post post = (Post) query.uniqueResult();
		return post;
	}

	public List<Post> getAllPosts() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Post> list = session.createCriteria(Post.class).list();
		return list;
	}

	public void updatePost(Post post)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(post);
		transaction.commit();		
	}

	public void deletePost(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Post post = session.get(Post.class, new Integer(id));
		session.delete(post);
		transaction.commit();
	}

	public List<Post> getAllAddedByClient(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Post where clientid = '"+id+"'");
		List<Post> list = query.list();
		return list;
	}
}
