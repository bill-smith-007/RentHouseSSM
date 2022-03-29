package com.house.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBean {
	private Integer U_id;// ��½��id
	private Integer R_id;
	private Integer M_id;
	private Date M_time_order;
	private Date M_time_pay;
	private Integer M_time;

	private Integer M_state;// �û���Ȩ�޻���
	private String M_people;// �û��ĸ��˽���

	private Double M_money;

	private Integer start; // ��ʼ��
	private Integer rows; // ��ȡ����

	public Integer getU_id() {
		return U_id;
	}

	public void setU_id(Integer u_id) {
		U_id = u_id;
	}

	public Integer getR_id() {
		return R_id;
	}

	public void setR_id(Integer r_id) {
		R_id = r_id;
	}

	public Integer getM_id() {
		return M_id;
	}

	public void setM_id(Integer m_id) {
		M_id = m_id;
	}

	public Date getM_time_order() {
		return M_time_order;
	}

	public void setM_time_order(Date m_time_order) {
		M_time_order = m_time_order;
	}

	public String getM_time_orderStr() {
		if (M_time_order==null) {
			return null;
		}
		else {
			return new SimpleDateFormat("yyyy-MM-dd").format(M_time_order);
		}
		
	}

	public Date getM_time_pay() {
		return M_time_pay;
	}

	public Integer getM_time() {
		return M_time;
	}

	public void setM_time(Integer m_time) {
		M_time = m_time;
	}

	public void setM_time_pay(Date m_time_pay) {
		M_time_pay = m_time_pay;
	}

	public String getM_time_payStr() {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").format(M_time_pay);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Integer getM_state() {
		return M_state;
	}

	public String getM_stateStr() {
		String getForState;
		switch (M_state) {
		case 0:
			getForState = "�Ѿ�֧��";
			break;
		default:
			getForState = "δ֧��";
			break;
		}
		return getForState;

	}

	public void setM_state(Integer m_state) {
		M_state = m_state;
	}

	public String getM_people() {
		return M_people;
	}

	public void setM_people(String m_people) {
		M_people = m_people;
	}

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

	public Double getM_money() {
		return M_money;
	}

	public void setM_money(Double m_money) {
		M_money = m_money;
	}

}
