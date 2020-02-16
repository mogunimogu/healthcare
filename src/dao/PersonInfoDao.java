package dao;

import java.util.List;

import pojo.PersonInfo;

public interface PersonInfoDao {
	    public void save(PersonInfo transientInstance);
	    
	    public void delete(PersonInfo persistentInstance);
		
		public PersonInfo findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public PersonInfo merge(PersonInfo detachedInstance);

}
