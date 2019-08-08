package com.datacraft.vo;

import java.util.HashMap;

public class ExcelInfoVO {
	private HashMap<Integer,String> info = new HashMap<Integer,String>();
	private int index;
	public void SetInfo(int key,String arr) {
		info.put(key,arr);
	}
	public String getInfo(int key) {
		return this.info.get(key).toString();
	}
	public void setIndex() {
		index = info.size();
	}
	public int getIndex() {
		return index;
	}
}
