package com.house.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HouseBean {
	private Integer R_id;// �����id����Ϊ�����ʹ�ã���������
	private String R_name;// ������ǳƣ�������ʱ������
	private Integer R_state;// �����״̬0��Ϊ����״̬
	private String R_class;// ��������ͣ���������һ����
	private String R_introduce;// ����Ľ���֮��
	private double R_price;// ����ļ۸�
	private Integer R_create_id;// ���䴴���ߵ�id
	// ���ղ����ĸ�ʽ
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// ��������ĸ�ʽ
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;// ����������

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
