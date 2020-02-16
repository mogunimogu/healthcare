package dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ItemsDao;
import pojo.Items;

/**
 * A data access object (DAO) providing persistence and search support for Items
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pojo.Items
 * @author MyEclipse Persistence Tools
 */
public class ItemsDaoImpl extends HibernateDaoSupport implements ItemsDao{
	private static final Logger log = LoggerFactory.getLogger(ItemsDaoImpl.class);
	// property constants
	public static final String ITEM_COUNT = "itemCount";
	public static final String ITEM_PRICE = "itemPrice";

	protected void initDao() {
		// do nothing
	}

	public void save(Items transientInstance) {
		log.debug("saving Items instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Items persistentInstance) {
		log.debug("deleting Items instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Items findById(java.lang.Integer id) {
		log.debug("getting Items instance with id: " + id);
		try {
			Items instance = (Items) getHibernateTemplate().get("pojo.Items",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Items> findByExample(Items instance) {
		log.debug("finding Items instance by example");
		try {
			List<Items> results = (List<Items>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Items instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Items as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Items> findByItemCount(Object itemCount) {
		return findByProperty(ITEM_COUNT, itemCount);
	}

	public List<Items> findByItemPrice(Object itemPrice) {
		return findByProperty(ITEM_PRICE, itemPrice);
	}

	public List findAll() {
		log.debug("finding all Items instances");
		try {
			String queryString = "from Items";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Items merge(Items detachedInstance) {
		log.debug("merging Items instance");
		try {
			Items result = (Items) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Items instance) {
		log.debug("attaching dirty Items instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Items instance) {
		log.debug("attaching clean Items instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ItemsDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ItemsDaoImpl) ctx.getBean("ItemsDAO");
	}
}