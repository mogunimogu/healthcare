package dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LifesignDao;
import pojo.Lifesign;

/**
 * A data access object (DAO) providing persistence and search support for
 * Lifesign entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Lifesign
 * @author MyEclipse Persistence Tools
 */
public class LifesignDaoImpl extends HibernateDaoSupport implements LifesignDao{
	private static final Logger log = LoggerFactory
			.getLogger(LifesignDaoImpl.class);
	// property constants
	public static final String BLOODPRESSURE_L = "bloodpressureL";
	public static final String BLOODPRESSURE_H = "bloodpressureH";
	public static final String GLUCOSE = "glucose";
	public static final String HEARTRATE = "heartrate";
	public static final String SAMPLINGTIME = "samplingtime";

	protected void initDao() {
		// do nothing
	}

	public void save(Lifesign transientInstance) {
		log.debug("saving Lifesign instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Lifesign persistentInstance) {
		log.debug("deleting Lifesign instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lifesign findById(java.lang.Integer id) {
		log.debug("getting Lifesign instance with id: " + id);
		try {
			Lifesign instance = (Lifesign) getHibernateTemplate().get(
					"pojo.Lifesign", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Lifesign> findByExample(Lifesign instance) {
		log.debug("finding Lifesign instance by example");
		try {
			List<Lifesign> results = (List<Lifesign>) getHibernateTemplate()
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
		log.debug("finding Lifesign instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Lifesign as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Lifesign> findByBloodpressureL(Object bloodpressureL) {
		return findByProperty(BLOODPRESSURE_L, bloodpressureL);
	}

	public List<Lifesign> findByBloodpressureH(Object bloodpressureH) {
		return findByProperty(BLOODPRESSURE_H, bloodpressureH);
	}

	public List<Lifesign> findByGlucose(Object glucose) {
		return findByProperty(GLUCOSE, glucose);
	}

	public List<Lifesign> findByHeartrate(Object heartrate) {
		return findByProperty(HEARTRATE, heartrate);
	}

	public List<Lifesign> findBySamplingtime(Object samplingtime) {
		return findByProperty(SAMPLINGTIME, samplingtime);
	}

	public List findAll() {
		log.debug("finding all Lifesign instances");
		try {
			String queryString = "from Lifesign";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Lifesign merge(Lifesign detachedInstance) {
		log.debug("merging Lifesign instance");
		try {
			Lifesign result = (Lifesign) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Lifesign instance) {
		log.debug("attaching dirty Lifesign instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lifesign instance) {
		log.debug("attaching clean Lifesign instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LifesignDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (LifesignDaoImpl) ctx.getBean("LifesignDAO");
	}
}