package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.PersonInfoDao;
import pojo.PersonInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * PersonInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.PersonInfo
 * @author MyEclipse Persistence Tools
 */
public class PersonInfoDaoImpl extends HibernateDaoSupport implements PersonInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(PersonInfoDaoImpl.class);
	// property constants
	public static final String PERINFO_AGE = "perinfoAge";
	public static final String PERINFO_WEIGTH = "perinfoWeigth";
	public static final String PERINFO_HEIGHT = "perinfoHeight";

	protected void initDao() {
		// do nothing
	}

	public void save(PersonInfo transientInstance) {
		log.debug("saving PersonInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonInfo persistentInstance) {
		log.debug("deleting PersonInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonInfo findById(java.lang.Integer id) {
		log.debug("getting PersonInfo instance with id: " + id);
		try {
			PersonInfo instance = (PersonInfo) getHibernateTemplate().get(
					"pojo.PersonInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PersonInfo> findByExample(PersonInfo instance) {
		log.debug("finding PersonInfo instance by example");
		try {
			List<PersonInfo> results = (List<PersonInfo>) getHibernateTemplate()
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
		log.debug("finding PersonInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PersonInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PersonInfo> findByPerinfoAge(Object perinfoAge) {
		return findByProperty(PERINFO_AGE, perinfoAge);
	}

	public List<PersonInfo> findByPerinfoWeigth(Object perinfoWeigth) {
		return findByProperty(PERINFO_WEIGTH, perinfoWeigth);
	}

	public List<PersonInfo> findByPerinfoHeight(Object perinfoHeight) {
		return findByProperty(PERINFO_HEIGHT, perinfoHeight);
	}

	public List findAll() {
		log.debug("finding all PersonInfo instances");
		try {
			String queryString = "from PersonInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PersonInfo merge(PersonInfo detachedInstance) {
		log.debug("merging PersonInfo instance");
		try {
			PersonInfo result = (PersonInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonInfo instance) {
		log.debug("attaching dirty PersonInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonInfo instance) {
		log.debug("attaching clean PersonInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PersonInfoDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (PersonInfoDaoImpl) ctx.getBean("PersonInfoDAO");
	}
}