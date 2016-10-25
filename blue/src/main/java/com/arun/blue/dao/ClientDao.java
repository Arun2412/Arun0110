package com.arun.blue.dao;

import java.util.List;
import com.arun.blue.model.Client;

public interface ClientDao 
{
	public void addClient(Client client);
	public void deleteClient(int id);
	public List<Client> getClients();
	public Client getOneClient(int id);
	public void updateClient(Client client);
	public Client getClientByName(String name);
}
