package cn.timeface.ebook.modules.test.service;

import cn.timeface.ebook.modules.test.entity.base.Items;

public interface ItemsService {

	Items findById(int id);
	
	void update(String id, String name);
}
