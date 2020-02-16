package dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.PublishDao;
import pojo.Publish;

/**
 * A data access object (DAO) providing persistence and search support for
 * Publish entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Publish
 * @author MyEclipse Persistence Tools
 */
public class PublishDaoImpl extends HibernateDaoSupport implements PublishDao{
	private static final Logger log = LoggerFactory.getLogger(PublishDaoImpl.class);
	// property constants
	public static final String PUBLISH_MASSQGE = "publishMassqge";

	protected void initDao() {
		// do nothing
	}

	public void save(Publish transientInstance) {
		log.debug("saving Publish instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publish persistentInstance) {
		log.debug("deleting Publish instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publish findById(java.lang.Integer id) {
		log.debug("getting Publish instance with id: " + id);
		try {
			Publish instance = (Publish) getHibernateTemplate().get(
					"pojo.Publish", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Publish> findByExample(Publish instance) {
		log.debug("finding Publish instance by example");
		try {
			List<Publish> results = (List<Publish>) getHibernateTemplate()
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
		log.debug("finding Publish instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Publish as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Publish> findByPublishMassqge(Object publishMassqge) {
		return findByProperty(PUBLISH_MASSQGE, publishMassqge);
	}

	public List findAll() {
		log.debug("finding all Publish instances");
		try {
			String queryString = "from Publish";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publish merge(Publish detachedInstance) {
		log.debug("merging Publish instance");
		try {
			Publish result = (Publish) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publish instance) {
		log.debug("attaching dirty Publish instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publish instance) {
		log.debug("attaching clean Publish instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PublishDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (PublishDaoImpl) ctx.getBean("PublishDAO");
	}
}