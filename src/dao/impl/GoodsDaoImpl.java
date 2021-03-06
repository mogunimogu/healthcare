package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.GoodsDao;
import pojo.Goods;

/**
 * A data access object (DAO) providing persistence and search support for Goods
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pojo.Goods
 * @author MyEclipse Persistence Tools
 */
public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao{
	private static final Logger log = LoggerFactory.getLogger(GoodsDaoImpl.class);
	// property constants
	public static final String GOODS_NAME = "goodsName";
	public static final String GOODS_PRICE = "goodsPrice";
	public static final String GOODS_STOCK = "goodsStock";
	public static final String GOODS_IMAGES = "goodsImages";
	public static final String GOODS_INTRODUCE = "goodsIntroduce";

	protected void initDao() {
		// do nothing
	}

	public void save(Goods transientInstance) {
		log.debug("saving Goods instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goods persistentInstance) {
		log.debug("deleting Goods instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goods findById(java.lang.Integer id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			Goods instance = (Goods) getHibernateTemplate().get("pojo.Goods",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Goods> findByExample(Goods instance) {
		log.debug("finding Goods instance by example");
		try {
			List<Goods> results = (List<Goods>) getHibernateTemplate()
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
		log.debug("finding Goods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Goods as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Goods> findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List<Goods> findByGoodsPrice(Object goodsPrice) {
		return findByProperty(GOODS_PRICE, goodsPrice);
	}

	public List<Goods> findByGoodsStock(Object goodsStock) {
		return findByProperty(GOODS_STOCK, goodsStock);
	}

	public List<Goods> findByGoodsImages(Object goodsImages) {
		return findByProperty(GOODS_IMAGES, goodsImages);
	}

	public List<Goods> findByGoodsIntroduce(Object goodsIntroduce) {
		return findByProperty(GOODS_INTRODUCE, goodsIntroduce);
	}

	public List findAll() {
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goods merge(Goods detachedInstance) {
		log.debug("merging Goods instance");
		try {
			Goods result = (Goods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goods instance) {
		log.debug("attaching dirty Goods instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goods instance) {
		log.debug("attaching clean Goods instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoodsDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (GoodsDaoImpl) ctx.getBean("GoodsDAO");
	}
}