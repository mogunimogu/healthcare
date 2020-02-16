package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.DoctorInfoDao;
import pojo.DoctorInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * DoctorInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.DoctorInfo
 * @author MyEclipse Persistence Tools
 */
public class DoctorInfoDaoImpl extends HibernateDaoSupport implements DoctorInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(DoctorInfoDaoImpl.class);
	// property constants
	public static final String DOCTOR_IMG = "doctorImg";
	public static final String DOCTOR_NAME = "doctorName";
	public static final String DOCTOR_AGE = "doctorAge";
	public static final String DOCTOR_RANK = "doctorRank";
	public static final String DOCTOR_SKILL = "doctorSkill";
	public static final String DOCTOR_TIME = "doctorTime";

	protected void initDao() {
		// do nothing
	}

	public void save(DoctorInfo transientInstance) {
		log.debug("saving DoctorInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DoctorInfo persistentInstance) {
		log.debug("deleting DoctorInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DoctorInfo findById(java.lang.Integer id) {
		log.debug("getting DoctorInfo instance with id: " + id);
		try {
			DoctorInfo instance = (DoctorInfo) getHibernateTemplate().get(
					"pojo.DoctorInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DoctorInfo> findByExample(DoctorInfo instance) {
		log.debug("finding DoctorInfo instance by example");
		try {
			List<DoctorInfo> results = (List<DoctorInfo>) getHibernateTemplate()
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
		log.debug("finding DoctorInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DoctorInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DoctorInfo> findByDoctorImg(Object doctorImg) {
		return findByProperty(DOCTOR_IMG, doctorImg);
	}

	public List<DoctorInfo> findByDoctorName(Object doctorName) {
		return findByProperty(DOCTOR_NAME, doctorName);
	}

	public List<DoctorInfo> findByDoctorAge(Object doctorAge) {
		return findByProperty(DOCTOR_AGE, doctorAge);
	}

	public List<DoctorInfo> findByDoctorRank(Object doctorRank) {
		return findByProperty(DOCTOR_RANK, doctorRank);
	}

	public List<DoctorInfo> findByDoctorSkill(Object doctorSkill) {
		return findByProperty(DOCTOR_SKILL, doctorSkill);
	}

	public List<DoctorInfo> findByDoctorTime(Object doctorTime) {
		return findByProperty(DOCTOR_TIME, doctorTime);
	}

	public List findAll() {
		log.debug("finding all DoctorInfo instances");
		try {
			String queryString = "from DoctorInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DoctorInfo merge(DoctorInfo detachedInstance) {
		log.debug("merging DoctorInfo instance");
		try {
			DoctorInfo result = (DoctorInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DoctorInfo instance) {
		log.debug("attaching dirty DoctorInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DoctorInfo instance) {
		log.debug("attaching clean DoctorInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DoctorInfoDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (DoctorInfoDaoImpl) ctx.getBean("DoctorInfoDAO");
	}
}