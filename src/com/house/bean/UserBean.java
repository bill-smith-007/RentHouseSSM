package com.house.bean;

public class UserBean {
	private Integer U_id;// ��½��id
	private String U_name;// ��¼���ǳƣ��û�����
	private String U_password;// ��¼���ǳƣ��û�����
	private Integer U_root;// �û���Ȩ�޻���
	private String U_introduce;// �û��ĸ��˽���

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

	public String getU_password() {
		return U_password;
	}

	public void setU_password(String u_password) {
		U_password = u_password;
	}

	public Integer getU_id() {
		return U_id;
	}

	public void setU_id(Integer u_id) {
		U_id = u_id;
	}

	public String getU_name() {
		return U_name;
	}

	public void setU_name(String u_name) {
		U_name = u_name;
	}

	public String getU_rootStr() {
		String getForRoot;
		switch (U_root) {
		case 0:
			getForRoot = "����Ա";
			break;
		default:
			getForRoot = "һ���û�";
			break;
		}
		return getForRoot;

	}

	public String getU_introduce() {
		return U_introduce;
	}

	public Integer getU_root() {
		return U_root;
	}

	public void setU_root(Integer u_root) {
		U_root = u_root;
	}

	public void setU_introduce(String u_introduce) {
		U_introduce = u_introduce;
	}

}
