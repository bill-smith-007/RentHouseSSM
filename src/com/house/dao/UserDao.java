package com.house.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public Integer CheckLogin(@Param("U_name")String U_name,@Param("U_password")String U_password);
 
}
