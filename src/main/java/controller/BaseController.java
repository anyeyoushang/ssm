package controller;

import common.utils.JsonData;

public class BaseController {
	
	public JsonData<Object> getJsonData(String code, Object obj){
		return new JsonData<Object>(code, obj);
	}
}
