package cn.timeface.ebook.modules.test.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.timeface.ebook.common.BaseController;
import cn.timeface.ebook.common.utils.CodeVal;
import cn.timeface.ebook.common.utils.JsonData;
import cn.timeface.ebook.modules.test.dao.ItemsCustomMapper;
import cn.timeface.ebook.modules.test.entity.ItemsCustom;
import cn.timeface.ebook.modules.test.entity.base.Items;
import cn.timeface.ebook.modules.test.service.impl.ItemsServiceImpl;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	ItemsServiceImpl itemsService;
	
	@Autowired
	ItemsCustomMapper ItemsCustomMapper;
	
	@ResponseBody
	@RequestMapping("/hello")
	public List<ItemsCustom> helloWorld(HttpServletRequest request) throws Exception{
		logger.info("123456");
		String token = request.getHeader("tf-token");
		String memberUid = request.getHeader("tf-uid");
		JSONObject jsonObject = getparaJson(request);
		System.out.println(jsonObject.getString("name"));
		System.out.println(jsonObject.getString("age"));
		Items Items = itemsService.findById(1);
		
		List<ItemsCustom> itemsOrderdetail = ItemsCustomMapper.getItemsOrderdetail();
		return itemsOrderdetail;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
	public String updateTx(HttpServletRequest request) {
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
	
/*	@RequestMapping(value="/onetoone",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody List<OrderdetailCustom> testOneToOne(){
		List<OrderdetailCustom> orderdetailItems = oMapper.getOrderdetailItems();
		return orderdetailItems;
	}*/
	
	@ResponseBody
	@RequestMapping("/onetomany")
	public JsonData<List<ItemsCustom>> testOneToMany(){
		PageHelper.startPage(2, 2);
		List<ItemsCustom> itemsOrderdetail = ItemsCustomMapper.getItemsOrderdetail();
		PageInfo<ItemsCustom> info = new PageInfo<>(itemsOrderdetail);
		List<ItemsCustom> list = info.getList();
		return new JsonData<List<ItemsCustom>>(CodeVal.SUCCESS, list);
	}
	
}
