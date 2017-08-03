package cn.timeface.ebook.common.utils;

import java.io.Serializable;

public class JsonData<T> implements Serializable {

	private static final long serialVersionUID = 4475329876461122752L;

	private String code = "";

	private T data;

	public String getCode() {
		return code;
	}

	public JsonData(String code, T data) {
		if (code.endsWith("000"))
			this.code = "000";
		else
			this.code = code;
		this.data = data;
	}
	public JsonData(String code) {
		if (code.endsWith("000"))
			this.code = "000";
		else
			this.code = code;
		this.data = null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public JsonData(){}
}
