package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.CodeVal;
import common.utils.JsonData;
import dao.ItemsCustomMapper;
import dao.base.ItemsMapper;
import entity.ItemsCustom;
import entity.base.Items;
import service.ItemsService;

@Controller
@RequestMapping("/hello")
public class HelloController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	ItemsMapper itemsMapper;
	
//	@Autowired
//	OrderdetailCustomMapper oMapper;

	@Autowired
	ItemsCustomMapper iMapper;
	
	@Autowired
	ItemsService itemsService;
	
	@RequestMapping("/helloWorld")
	public @ResponseBody Items helloWorld(HttpServletRequest request) throws Exception{
		logger.info("123456");
		System.out.println(request.getParameter("name"));
		// Items items = itemsMapper.selectByPrimaryKey(1);
		Items items = itemsService.findById(1);
		return items;
	}
	
	@RequestMapping("/update")
	public @ResponseBody String updateTx(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			itemsService.update(id, name);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
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
