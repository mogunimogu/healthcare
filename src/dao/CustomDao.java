package dao;

import java.util.List;

import pojo.Custom;

public interface CustomDao {

    public void save(Custom transientInstance);
	
	public void delete(Custom persistentInstance);
	
	public Custom findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Custom merge(Custom detachedInstance);
	
}
