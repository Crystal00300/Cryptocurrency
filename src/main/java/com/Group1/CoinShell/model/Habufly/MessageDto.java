package com.Group1.CoinShell.model.Habufly;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto implements Serializable{
	
	@JsonProperty("message")//前端屬性名稱可調整
	private String msg;
	
	public MessageDto() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
