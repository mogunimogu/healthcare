package service;

import pojo.Lifesign;
import pojo.PersonInfo;

public interface LifesignService {

	public Lifesign getLifesignByPersoninfo(PersonInfo personinfo);
}
