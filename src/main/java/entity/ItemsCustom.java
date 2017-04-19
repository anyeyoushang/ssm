package entity;

import java.util.List;

import entity.base.Items;
import entity.base.Orderdetail;

public class ItemsCustom extends Items {

	List<Orderdetail> orderdetailList;

	public List<Orderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<Orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}

}
