package service;

import entity.base.Items;

public interface ItemsService {

	Items findById(int id);

	void update(String id, String name);
}
