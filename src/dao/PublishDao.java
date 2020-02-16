package dao;

import java.util.List;

import pojo.Publish;

public interface PublishDao {
	public void save(Publish transientInstance);
    
    public void delete(Publish persistentInstance);
	
	public Publish findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Publish merge(Publish detachedInstance);
}
