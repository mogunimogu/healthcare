package dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.DoctorSubscribeDao;
import pojo.DoctorSubscribe;

/**
 * A data access object (DAO) providing persistence and search support for
 * DoctorSubscribe entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pojo.DoctorSubscribe
 * @author MyEclipse Persistence Tools
 */
public class DoctorSubscribeDaoImpl extends HibernateDaoSupport implements DoctorSubscribeDao{
	private static final Logger log = LoggerFactory
			.getLogger(DoctorSubscribeDaoImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(DoctorSubscribe transientInstance) {
		log.debug("saving DoctorSubscribe instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DoctorSubscribe persistentInstance) {
		log.debug("deleting DoctorSubscribe instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DoctorSubscribe findById(java.lang.Integer id) {
		log.debug("getting DoctorSubscribe instance with id: " + id);
		try {
			DoctorSubscribe instance = (DoctorSubscribe) getHibernateTemplate()
					.get("pojo.DoctorSubscribe", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DoctorSubscribe> findByExample(DoctorSubscribe instance) {
		log.debug("finding DoctorSubscribe instance by example");
		try {
			List<DoctorSubscribe> results = (List<DoctorSubscribe>) getHibernateTemplate()
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
		log.debug("finding DoctorSubscribe instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DoctorSubscribe as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all DoctorSubscribe instances");
		try {
			String queryString = "from DoctorSubscribe";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DoctorSubscribe merge(DoctorSubscribe detachedInstance) {
		log.debug("merging DoctorSubscribe instance");
		try {
			DoctorSubscribe result = (DoctorSubscribe) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DoctorSubscribe instance) {
		log.debug("attaching dirty DoctorSubscribe instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DoctorSubscribe instance) {
		log.debug("attaching clean DoctorSubscribe instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DoctorSubscribeDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (DoctorSubscribeDaoImpl) ctx.getBean("DoctorSubscribeDAO");
	}
}