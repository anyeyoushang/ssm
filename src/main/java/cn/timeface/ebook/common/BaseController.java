package cn.timeface.ebook.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.timeface.ebook.common.utils.JsonData;


public class BaseController {
	
	protected JsonData<Object> getJsonData(String code, Object obj){
		return new JsonData<Object>(code, obj);
	}
	
	protected JSONObject getparaJson(HttpServletRequest request) {
		try {
			InputStream is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String readLine = br.readLine();
			br.close();
			is.close();
			return JSON.parseObject(readLine);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
