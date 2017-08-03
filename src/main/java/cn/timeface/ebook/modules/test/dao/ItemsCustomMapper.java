package cn.timeface.ebook.modules.test.dao;

import java.util.List;

import cn.timeface.ebook.modules.test.entity.ItemsCustom;
import cn.timeface.ebook.modules.test.entity.base.Items;


public interface ItemsCustomMapper {
	Items getItemsInfo(Items items);

	List<ItemsCustom> getItemsOrderdetail();

	List<Items> getAllItems();
}
