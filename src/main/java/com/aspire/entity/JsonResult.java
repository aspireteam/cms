package com.aspire.entity;

import java.io.Serializable;

public class JsonResult implements Serializable{
	
	private static final long serialVersionUID = -8268568420399312880L;
	
	// 设置常量SUCCESS=0,ERROR=1
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	
	private int state;
	// 返回的消息
	private String message;
	// 返回的数据
	private Object data;

	public JsonResult() {}
	
	public JsonResult(String error){
		state = ERROR;
		this.message = error;
	}
	
	public JsonResult(Object data){
		state = SUCCESS;
		this.data = data;
	}
	
	public JsonResult(int state,String message){
		state = SUCCESS;
		this.message = message;
	}
	
	public JsonResult(Throwable e) {
		state = ERROR;
		message = e.getMessage();
	}
	
	public JsonResult(int state, Throwable e) {
		this.state = state;
		this.message = e.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
