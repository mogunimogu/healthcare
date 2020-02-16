package dao;

import java.util.List;

import pojo.ShoppingCart;

public interface ShoppingCartDao {
	    public void save(ShoppingCart transientInstance);
	    
	    public void delete(ShoppingCart persistentInstance);
		
		public ShoppingCart findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public ShoppingCart merge(ShoppingCart detachedInstance);

}
