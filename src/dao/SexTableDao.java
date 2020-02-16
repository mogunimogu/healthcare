package dao;

import java.util.List;

import pojo.SexTable;

public interface SexTableDao {
    public void save(SexTable transientInstance);
    
    public void delete(SexTable persistentInstance);
	
	public SexTable findById(java.lang.Integer id);
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	public SexTable merge(SexTable detachedInstance);
}
