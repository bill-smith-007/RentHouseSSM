package com.house.bean;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HouseBean {
	private Integer R_id;// �����id����Ϊ�����ʹ�ã���������
	private String R_name;// ������ǳƣ�������ʱ������
	private Integer R_state;// �����״̬0��Ϊ����״̬
	private String R_class_name;// ��������ͣ���������һ����
	private Integer R_class_id;
	private String R_introduce;// ����Ľ���֮��
	private Double R_price;// ����ļ۸�
	private Integer R_create_id;// ���䴴���ߵ�id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date R_ceate_time;// ����������

	private Integer start; // ��ʼ��
	private Integer rows; // ��ȡ����


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
			getForState = "����";
			break;
		default:
			getForState = "�Ѿ����";
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
