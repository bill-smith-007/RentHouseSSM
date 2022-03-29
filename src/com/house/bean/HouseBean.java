package com.house.bean;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HouseBean {
	private Integer R_id;// 房间的id，作为房间号使用（主键）。
	private String R_name;// 房间的昵称，创建的时候名称
	private Integer R_state;// 房间的状态0作为可用状态
	private String R_class_name;// 房间的类型（类似三室一厅）
	private Integer R_class_id;
	private String R_introduce;// 房间的介绍之类
	private Double R_price;// 房间的价格
	private Integer R_create_id;// 房间创造者的id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date R_ceate_time;// 创建的日期

	private Integer start; // 起始行
	private Integer rows; // 所取行数


	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getR_create_id() {
		return R_create_id;
	}

	public Integer getR_class_id() {
		return R_class_id;
	}

	public void setR_class_id(Integer r_class_id) {
		R_class_id = r_class_id;
	}

	public void setR_create_id(Integer r_create_id) {
		R_create_id = r_create_id;
	}

	public Integer getR_id() {
		return R_id;
	}

	public void setR_id(Integer r_id) {
		R_id = r_id;
	}

	public String getR_name() {
		return R_name;
	}

	public void setR_name(String r_name) {
		R_name = r_name;
	}

	public Integer getR_state() {
		return R_state;
	}

	public String getR_state_Str() {
		String getForState;
		switch (R_state) {
		case 0:
			getForState = "可用";
			break;
		default:
			getForState = "已经租出";
			break;
		}
		return getForState;

	}

	public void setR_state(Integer r_state) {
		R_state = r_state;
	}

	public String getR_class_name() {
		return R_class_name;
	}

	public void setR_class_name(String r_class_name) {
		R_class_name = r_class_name;
	}

	public Date getR_ceate_time() {
		return R_ceate_time;
	}

	public void setR_ceate_time(Date r_ceate_time) {
		R_ceate_time = r_ceate_time;
	}

	public String getR_ceate_timeStr() {
		
		return new SimpleDateFormat("yyyy-MM-dd").format(R_ceate_time);
	}

	public String getR_introduce() {
		return R_introduce;
	}

	public void setR_introduce(String r_introduce) {
		R_introduce = r_introduce;
	}

	public Double getR_price() {
		return R_price;
	}

	public void setR_price(Double r_price) {
		R_price = r_price;
	}

	
}
