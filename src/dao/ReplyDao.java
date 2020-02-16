package dao;

import java.util.List;

import pojo.Reply;

public interface ReplyDao {
    public void save(Reply transientInstance);
    
    public void delete(Reply persistentInstance);
	
	public Reply findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Reply merge(Reply detachedInstance);
}
