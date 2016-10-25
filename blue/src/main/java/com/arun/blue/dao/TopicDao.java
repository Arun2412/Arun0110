package com.arun.blue.dao;

import java.util.List;
import com.arun.blue.model.Topic;

public interface TopicDao
{
	public void addTopic(Topic topic);
	public Topic getTopic(int id);
	public List<Topic> getAllTopics();
	public void updateTopic(Topic topic);
	public void deleteTopic(int id);
	public List<Topic> getAllAddedByClient(int id);
}
