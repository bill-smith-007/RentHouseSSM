package com.house.dao;

import org.apache.ibatis.annotations.Param;

import com.house.bean.HouseBean;
import com.house.bean.UserBean;

public interface UserDao {
	public Integer CheckLogin(@Param("U_name")String U_name,@Param("U_password")String U_password);
	public UserBean getUserById(int U_id);
	public int createHouse(HouseBean room);// 创建房间
	public HouseBean getHouseById(Integer id);
	
	public int updateHouse(HouseBean room);// 更新房间信息

	int deleteHouse (Integer id);	// 删除房间
}
