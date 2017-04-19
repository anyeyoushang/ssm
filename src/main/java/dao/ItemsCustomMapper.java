package dao;

import java.util.List;

import entity.ItemsCustom;
import entity.base.Items;

public interface ItemsCustomMapper {
	Items getItemsInfo(Items items);

	List<ItemsCustom> getItemsOrderdetail();

}
