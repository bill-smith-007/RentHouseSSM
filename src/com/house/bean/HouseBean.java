package com.house.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HouseBean {
	private Integer R_id;// 房间的id，作为房间号使用（主键）。
	private String R_name;// 房间的昵称，创建的时候名称
	private Integer R_state;// 房间的状态0作为可用状态
	private String R_class;// 房间的类型（类似三室一厅）
	private String R_introduce;// 房间的介绍之类
	private double R_price;// 房间的价格
	private Integer R_create_id;// 房间创造者的id
	// 接收参数的格式
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// 输出参数的格式
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;// 创建的日期

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

	public void setR_create_id(Integer r_create_id) {
		R_create_id = r_create_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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

	public String getR_class() {
		return R_class;
	}

	public void setR_class(String r_class) {
		R_class = r_class;
	}

	public String getR_introduce() {
		return R_introduce;
	}

	public void setR_introduce(String r_introduce) {
		R_introduce = r_introduce;
	}

	public double getR_price() {
		return R_price;
	}

	public void setR_price(double r_price) {
		R_price = r_price;
	}

}
