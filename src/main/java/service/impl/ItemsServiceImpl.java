package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.base.ItemsMapper;
import entity.base.Items;
import service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	ItemsMapper itemsMapper;
	
	@Override
	public Items findById(int id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	@Transactional
	public void update(String id, String name) {
		Items items = itemsMapper.selectByPrimaryKey(Integer.valueOf(id));
		items.setName(name);
		itemsMapper.updateByPrimaryKey(items);
	}
	
}
