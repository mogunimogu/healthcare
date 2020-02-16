package dao;

import java.util.List;

import pojo.News;

public interface NewsDao {
	    public void save(News transientInstance);
	    
	    public void delete(News persistentInstance);
		
		public News findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public News merge(News detachedInstance);
}
