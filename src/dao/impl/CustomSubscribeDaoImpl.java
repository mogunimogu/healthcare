package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CustomSubscribeDao;
import pojo.CustomSubscribe;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomSubscribe entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pojo.CustomSubscribe
 * @author MyEclipse Persistence Tools
 */
public class CustomSubscribeDaoImpl extends HibernateDaoSupport implements CustomSubscribeDao{
	private static final Logger log = LoggerFactory
			.getLogger(CustomSubscribeDaoImpl.class);
	// property constants
	public static final String SUBSCRIBE_DATE = "subscribeDate";
	public static final String CUSTOM_NAME = "customName";

	protected void initDao() {
		// do nothing
	}

	public void save(CustomSubscribe transientInstance) {
		log.debug("saving CustomSubscribe instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CustomSubscribe persistentInstance) {
		log.debug("deleting CustomSubscribe instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomSubscribe findById(java.lang.Integer id) {
		log.debug("getting CustomSubscribe instance with id: " + id);
		try {
			CustomSubscribe instance = (CustomSubscribe) getHibernateTemplate()
					.get("pojo.CustomSubscribe", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CustomSubscribe> findByExample(CustomSubscribe instance) {
		log.debug("finding CustomSubscribe instance by example");
		try {
			List<CustomSubscribe> results = (List<CustomSubscribe>) getHibernateTemplate()
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
		log.debug("finding CustomSubscribe instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CustomSubscribe as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CustomSubscribe> findBySubscribeDate(Object subscribeDate) {
		return findByProperty(SUBSCRIBE_DATE, subscribeDate);
	}

	public List<CustomSubscribe> findByCustomName(Object customName) {
		return findByProperty(CUSTOM_NAME, customName);
	}

	public List findAll() {
		log.debug("finding all CustomSubscribe instances");
		try {
			String queryString = "from CustomSubscribe";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomSubscribe merge(CustomSubscribe detachedInstance) {
		log.debug("merging CustomSubscribe instance");
		try {
			CustomSubscribe result = (CustomSubscribe) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomSubscribe instance) {
		log.debug("attaching dirty CustomSubscribe instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomSubscribe instance) {
		log.debug("attaching clean CustomSubscribe instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomSubscribeDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomSubscribeDaoImpl) ctx.getBean("CustomSubscribeDAO");
	}
}