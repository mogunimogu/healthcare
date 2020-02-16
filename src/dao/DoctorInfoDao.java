package dao;

import java.util.List;

import pojo.DoctorInfo;

public interface DoctorInfoDao {
	   public void save(DoctorInfo transientInstance);
	    
	    public void delete(DoctorInfo persistentInstance);
		
		public DoctorInfo findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public DoctorInfo merge(DoctorInfo detachedInstance);

}
