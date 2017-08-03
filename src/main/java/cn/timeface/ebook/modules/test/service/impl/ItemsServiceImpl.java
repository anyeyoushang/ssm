package cn.timeface.ebook.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.timeface.ebook.modules.test.dao.ItemsCustomMapper;
import cn.timeface.ebook.modules.test.dao.base.ItemsMapper;
import cn.timeface.ebook.modules.test.entity.base.Items;
import cn.timeface.ebook.modules.test.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	ItemsMapper itemsMapper;
	
	@Autowired
	ItemsCustomMapper itemsCustomMapper;
	
	@Override
	public Items findById(int id) {
		/*ItemsExample itemsExample = new ItemsExample();
		Criteria criteria = itemsExample.createCriteria();
		criteria.andIdEqualTo(1);
		criteria.andNameLike("%ha%");
		List<Items> list = itemsMapper.selectByExample(itemsExample);
		// Items items = itemsMapper.selectByPrimaryKey(1);
		if(list.size() > 0) {
			return list.get(0);
		}else{
			return null;
		}*/
		
		// 设置页数
		PageHelper.startPage(2, 2);
		// 查询数据
		List<Items> list = itemsCustomMapper.getAllItems();
		// 获取查询内容
		PageInfo<Items> info = new PageInfo<>(list);
		
		System.out.println("当前页码："+info.getPageNum());
		System.out.println("总记录数："+info.getTotal());
		System.out.println("每页的记录数："+info.getPageSize());
		System.out.println("总页码："+info.getPages());
		System.out.println("是否第一页："+info.isIsFirstPage());
		return list.get(0);
	}

	@Override
	@Transactional
	public void update(String id, String name) {
		Items items = itemsMapper.selectByPrimaryKey(Integer.valueOf(id));
		items.setName(name);
		itemsMapper.updateByPrimaryKey(items);
	}

}
