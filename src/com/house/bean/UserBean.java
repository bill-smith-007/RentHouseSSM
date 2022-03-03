package com.house.bean;

public class UserBean {
	private Integer U_id;// 登陆的id
	private String U_name;// 登录的昵称（用户名）
	private String U_password;// 登录的昵称（用户名）
	private Integer U_root;// 用户的权限划分
	private String U_introduce;// 用户的个人介绍

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
			getForRoot = "管理员";
			break;
		default:
			getForRoot = "一般用户";
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
