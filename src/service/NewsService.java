package service;

import java.util.List;

import pojo.News;

public interface NewsService {
	public List<News> getAllNews();
	public News getNewsById(Integer newsId);
}
