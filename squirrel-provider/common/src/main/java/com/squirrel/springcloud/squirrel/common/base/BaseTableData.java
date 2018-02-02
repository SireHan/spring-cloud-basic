package com.squirrel.springcloud.squirrel.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * DataTable 基本的数据格式
 * Created by JoinHan on 2017/4/19.
 */
public class BaseTableData<T> {
	/*
	    {
		  "draw": 4,
		  "recordsTotal": 57,
		  "recordsFiltered": 57,
		  "data": [
		    [
		      "Charde",
		      "Marshall",
		      "Regional Director",
		      "San Francisco",
		      "16th Oct 08",
		      "$470,600"
		    ],[]...
		  }
	 */
	public BaseTableData() {
		draw=0;
		recordsTotal=0;
		recordsFiltered=0;
		data = new ArrayList<>();
	}
	long draw;
	long recordsTotal;
	long recordsFiltered;
	List<T> data;
	
	public long getDraw() {
		return draw;
	}
	public void setDraw(long draw) {
		this.draw = draw;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	} 
}
