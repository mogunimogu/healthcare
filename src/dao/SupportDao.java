package dao;

import java.util.List;

import pojo.Support;

public interface SupportDao {
    public void save(Support transientInstance);
    
    public void delete(Support persistentInstance);
	
	public Support findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Support merge(Support detachedInstance);

}
