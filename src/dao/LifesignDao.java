package dao;

import java.util.List;

import pojo.Lifesign;

public interface LifesignDao {
	    public void save(Lifesign transientInstance);
	    
	    public void delete(Lifesign persistentInstance);
		
		public Lifesign findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public Lifesign merge(Lifesign detachedInstance);

}
