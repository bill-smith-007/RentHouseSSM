package com.house.dao;

import org.apache.ibatis.annotations.Param;

import com.house.bean.UserBean;

public interface UserDao {
	public Integer CheckLogin(@Param("U_name")String U_name,@Param("U_password")String U_password);
	public UserBean getUserById(int U_id);
}
