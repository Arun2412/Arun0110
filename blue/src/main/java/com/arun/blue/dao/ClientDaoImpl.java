package com.arun.blue.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.blue.model.Client;
import com.arun.blue.model.Post;
import com.arun.blue.model.UserRole;

@Repository
public class ClientDaoImpl implements ClientDao
{
	@Autowired(required=true)
	SessionFactory sessionFactory;
	public void addClient(Client client) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		client.setEnabled(true);
		session.saveOrUpdate(client);
		UserRole userRole = new UserRole();
		userRole.setId(client.getClientid());
		userRole.setAuthority("ROLE_y");
		session.saveOrUpdate(userRole);
		transaction.commit();		
	}

	public void deleteClient(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Client client = session.get(Client.class, new Integer(id));
		session.delete(client);
		transaction.commit();
	}

	public List<Client> getClients() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Client> list = session.createCriteria(Client.class).list();
		return list;
	}

	public Client getOneClient(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Client where id = '"+id+"'");
		return (Client) query.uniqueResult();
	}

	public void updateClient(Client client)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Client where clientid = '"+client.getClientid()+"'");
		Client oldClient = (Client) query.uniqueResult();
		client.setPassword(oldClient.getPassword());
		Session session1 = sessionFactory.openSession();
		session1.update(client);
		transaction.commit();
	}

	public Client getClientByName(String name)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Client activeUser =  (Client) session.createCriteria(Client.class)
			     .add(Restrictions.like("name", name)).uniqueResult();
		return activeUser;
	}
}
