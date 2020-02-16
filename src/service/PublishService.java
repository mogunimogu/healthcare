package service;

import java.util.List;

import pojo.Custom;
import pojo.Publish;

public interface PublishService {
	public List<Publish> getAllPublish();
	public boolean insertPublish(Publish publish);
	public Publish getPublishById(Integer id);
}
