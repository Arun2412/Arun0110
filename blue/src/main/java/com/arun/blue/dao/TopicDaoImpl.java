package com.arun.blue.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.blue.model.Post;
import com.arun.blue.model.Topic;

@Repository
public class TopicDaoImpl implements TopicDao
{
	@Autowired
	SessionFactory sessionFactory;
	public void addTopic(Topic topic) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(topic);
		transaction.commit();
	}

	public Topic getTopic(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Topic where id = '"+id+"'");
		Topic topic = (Topic) query.uniqueResult();
		return topic;
	}

	public List<Topic> getAllTopics()
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Topic> list = session.createCriteria(Topic.class).list();
		return list;
	}

	public void updateTopic(Topic topic)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(topic);
		transaction.commit();
	}

	public void deleteTopic(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Topic topic = session.get(Topic.class, new Integer(id));
		session.delete(topic);
		transaction.commit();
	}

	public List<Topic> getAllAddedByClient(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Topic where clientid = '"+id+"'");
		List<Topic> list = query.list();
		return list;
	}

}
