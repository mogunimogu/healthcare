package service.impl;

import java.util.List;

import dao.NewsDao;
import pojo.News;
import service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsdao;
	
	public NewsDao getNewsdao() {
		return newsdao;
	}

	public void setNewsdao(NewsDao newsdao) {
		this.newsdao = newsdao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getAllNews() {
		List<News> nlist = newsdao.findAll();
		return nlist;
	}

	@Override
	public News getNewsById(Integer newsId) {
		News news =	newsdao.findById(newsId);
		return news;
	}

}
