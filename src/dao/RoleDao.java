package dao;

import java.util.List;

import pojo.Role;

public interface RoleDao {
    public void save(Role transientInstance);
    
    public void delete(Role persistentInstance);
	
	public Role findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public Role merge(Role detachedInstance);

}
