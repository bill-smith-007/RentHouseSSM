package com.house.bean;

public class UserBean {
  private int U_id;//登陆的id
  private String U_name;//登录的昵称（用户名）
  private String U_passworld;//登录的昵称（用户名）
  private int U_root;//用户的权限划分
  private int U_introduce;//用户的个人介绍
  public String getU_passworld() {
	  return U_passworld;
  }
  public void setU_passworld(String u_passworld) {
		U_passworld = u_passworld;
  }

  
  
  public int getU_id() {
	  return U_id;
  }
  public void setU_id(int u_id) {
	  U_id = u_id;
  }
  
  
  public String getU_name() {
	  return U_name;
  }
  public void setU_name(String u_name) {
	  U_name = u_name;
  }
  public String getU_name_Str() {
	  String getForRoot;
	  switch (U_root) {
	  	case 0:
	  		getForRoot="管理员";
	  		break;
	  	default:
	  		getForRoot="一般用户";
	  		break;
	}
	return getForRoot;
	
}
  
  
  public int getU_root() {
	  return U_root;
  }
  public void setU_root(int u_root) {
	  U_root = u_root;
  }
  
  
  public int getU_introduce() {
	  return U_introduce;
  }
  public void setU_introduce(int u_introduce) {
	  U_introduce = u_introduce;
  }
  	
  
}
