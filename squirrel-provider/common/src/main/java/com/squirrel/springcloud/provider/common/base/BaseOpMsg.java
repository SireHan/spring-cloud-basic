package com.squirrel.springcloud.provider.common.base;

import java.util.List;
import java.util.Map;

/**
 * 操作结果信息 统一json返回
 * Created by JoinHan on 2017/4/22.
 */
public class BaseOpMsg<T> {
	
	//状态码
	private int code;
	//状态
	private String status;
	//文本信息 （用于显示信息）
	private String msg;
	//返回的单个对象
	private T object;
	//返回的数组对象
	private List<T> list;
	//返回的Map对象
	private Map<String,Object> map;
	
	//详细信息 （用于排查错误）
	private String description;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
