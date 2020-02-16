package dao;

import java.util.List;

import pojo.CustomSubscribe;

public interface CustomSubscribeDao {
    public void save(CustomSubscribe transientInstance);
    
    public void delete(CustomSubscribe persistentInstance);
	
	public CustomSubscribe findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public CustomSubscribe merge(CustomSubscribe detachedInstance);

}
