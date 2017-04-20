package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.CodeVal;
import common.utils.JsonData;
import dao.ItemsCustomMapper;
import dao.base.ItemsMapper;
import entity.ItemsCustom;
import entity.base.Items;

@Controller
@RequestMapping("/hello")
public class HelloController extends BaseController {
	@Autowired
	ItemsMapper itemsMapper;
	
//	@Autowired
//	OrderdetailCustomMapper oMapper;

	@Autowired
	ItemsCustomMapper iMapper;
	
	@RequestMapping("/helloWorld")
	public @ResponseBody Items helloWorld(HttpServletRequest request) throws Exception{
		System.out.println(request.getParameter("name"));
		Items items = itemsMapper.selectByPrimaryKey(1);
		return items;
	}
	
//	@RequestMapping(value="/onetoone",method={RequestMethod.POST,RequestMethod.GET})
//	public @ResponseBody List<OrderdetailCustom> testOneToOne(){
//		List<OrderdetailCustom> orderdetailItems = oMapper.getOrderdetailItems();
//		return orderdetailItems;
//	}
	
	@RequestMapping("/onetomany")
	public @ResponseBody JsonData<List<ItemsCustom>> testOneToMany(){
		List<ItemsCustom> itemsOrderdetail = iMapper.getItemsOrderdetail();
		return new JsonData<List<ItemsCustom>>(CodeVal.SUCCESS, itemsOrderdetail);
	}
	
}
