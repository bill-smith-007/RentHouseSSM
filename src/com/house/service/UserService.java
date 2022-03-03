package com.house.service;


import com.house.bean.UserBean;
import com.house.common.utils.Page;

public interface UserService {
	public Page<UserBean> findUserList(Integer page, Integer rows, 
            Integer U_id,String U_name);
	Integer CheckLogin(String U_name, String U_passworld);

	public UserBean GetUserById(Integer U_id);

	public int createUser(UserBean user);



	public int updateUser(UserBean user);

	int deleteUser(Integer id); 
}
