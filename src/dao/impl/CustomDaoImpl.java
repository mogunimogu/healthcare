package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CustomDao;
import pojo.Custom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Custom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Custom
 * @author MyEclipse Persistence Tools
 */
public class CustomDaoImpl extends HibernateDaoSupport implements CustomDao{
	private static final Logger log = LoggerFactory.getLogger(CustomDaoImpl.class);
	// property constants
	public static final String CUSTOM_NAME = "customName";
	public static final String CUSTOM_PWD = "customPwd";
	public static final String CUSTOM_EMAIL = "customEmail";

	protected void initDao() {
		// do nothing
	}

	public void save(Custom transientInstance) {
		log.debug("saving Custom instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Custom persistentInstance) {
		log.debug("deleting Custom instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Custom findById(java.lang.Integer id) {
		log.debug("getting Custom instance with id: " + id);
		try {
			Custom instance = (Custom) getHibernateTemplate().get(
					"pojo.Custom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Custom> findByExample(Custom instance) {
		log.debug("finding Custom instance by example");
		try {
			List<Custom> results = (List<Custom>) getHibernateTemplate()
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
		log.debug("finding Custom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Custom as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Custom> findByCustomName(Object customName) {
		return findByProperty(CUSTOM_NAME, customName);
	}

	public List<Custom> findByCustomPwd(Object customPwd) {
		return findByProperty(CUSTOM_PWD, customPwd);
	}

	public List<Custom> findByCustomEmail(Object customEmail) {
		return findByProperty(CUSTOM_EMAIL, customEmail);
	}

	public List findAll() {
		log.debug("finding all Custom instances");
		try {
			String queryString = "from Custom";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Custom merge(Custom detachedInstance) {
		log.debug("merging Custom instance");
		try {
			Custom result = (Custom) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Custom instance) {
		log.debug("attaching dirty Custom instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Custom instance) {
		log.debug("attaching clean Custom instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (CustomDaoImpl) ctx.getBean("CustomDAO");
	}
}