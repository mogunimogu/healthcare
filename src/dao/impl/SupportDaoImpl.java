package dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.SupportDao;
import pojo.Support;

/**
 * A data access object (DAO) providing persistence and search support for
 * Support entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Support
 * @author MyEclipse Persistence Tools
 */
public class SupportDaoImpl extends HibernateDaoSupport implements SupportDao{
	private static final Logger log = LoggerFactory.getLogger(SupportDaoImpl.class);
	// property constants
	public static final String CUSTOM_ID = "customId";
	public static final String PUBLISH_ID = "publishId";

	protected void initDao() {
		// do nothing
	}

	public void save(Support transientInstance) {
		log.debug("saving Support instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Support persistentInstance) {
		log.debug("deleting Support instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Support findById(java.lang.Integer id) {
		log.debug("getting Support instance with id: " + id);
		try {
			Support instance = (Support) getHibernateTemplate().get(
					"pojo.Support", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Support> findByExample(Support instance) {
		log.debug("finding Support instance by example");
		try {
			List<Support> results = (List<Support>) getHibernateTemplate()
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
		log.debug("finding Support instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Support as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Support> findByCustomId(Object customId) {
		return findByProperty(CUSTOM_ID, customId);
	}

	public List<Support> findByPublishId(Object publishId) {
		return findByProperty(PUBLISH_ID, publishId);
	}

	public List findAll() {
		log.debug("finding all Support instances");
		try {
			String queryString = "from Support";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Support merge(Support detachedInstance) {
		log.debug("merging Support instance");
		try {
			Support result = (Support) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Support instance) {
		log.debug("attaching dirty Support instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Support instance) {
		log.debug("attaching clean Support instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SupportDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (SupportDaoImpl) ctx.getBean("SupportDAO");
	}
}