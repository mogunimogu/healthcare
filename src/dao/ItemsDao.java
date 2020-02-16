package dao;

import java.util.List;

import pojo.Items;

public interface ItemsDao {
	    public void save(Items transientInstance);
	    
	    public void delete(Items persistentInstance);
		
		public Items findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public Items merge(Items detachedInstance);

}
