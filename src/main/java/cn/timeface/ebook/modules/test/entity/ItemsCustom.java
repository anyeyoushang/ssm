package cn.timeface.ebook.modules.test.entity;

import java.util.List;

import cn.timeface.ebook.modules.test.entity.base.Items;
import cn.timeface.ebook.modules.test.entity.base.Orderdetail;


public class ItemsCustom extends Items {

	List<Orderdetail> orderdetailList;

	public List<Orderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<Orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}

}
