package com.house.service;

import com.house.bean.UserBean;

public interface UserService {
	 Integer CheckLogin(String U_name,String U_passworld);
	 public UserBean GetUserById(int U_id);
}
