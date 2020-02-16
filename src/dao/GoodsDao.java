package dao;

import java.util.List;

import pojo.Goods;

public interface GoodsDao {
	    public void save(Goods transientInstance);
	    
	    public void delete(Goods persistentInstance);
		
		public Goods findById(java.lang.Integer id);
		
		@SuppressWarnings("rawtypes")
		public List findByProperty(String propertyName, Object value);
		
		@SuppressWarnings("rawtypes")
		public List findAll();
		
		public Goods merge(Goods detachedInstance);

}
