package dao;

import java.util.List;

import pojo.Consume;

public interface ConsumeDao {
	public void save(Consume transientInstance);
	
	public void delete(Consume persistentInstance);
	
	public Consume findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Consume merge(Consume detachedInstance);
}
