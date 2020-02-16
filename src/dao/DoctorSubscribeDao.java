package dao;

import java.util.List;

import pojo.DoctorSubscribe;

public interface DoctorSubscribeDao {
	    public void save(DoctorSubscribe transientInstance);
	    
	    public void delete(DoctorSubscribe persistentInstance);
		
		public DoctorSubscribe findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public DoctorSubscribe merge(DoctorSubscribe detachedInstance);
}
