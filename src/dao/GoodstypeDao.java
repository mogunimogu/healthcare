package dao;

import java.util.List;

import pojo.Goodstype;

public interface GoodstypeDao {
	    public void save( Goodstype transientInstance);
	    
	    public void delete( Goodstype persistentInstance);
		
		public  Goodstype findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public  Goodstype merge( Goodstype detachedInstance);
}
