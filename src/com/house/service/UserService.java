package com.house.service;

import com.house.bean.HouseBean;
import com.house.bean.UserBean;

public interface UserService {
	 Integer CheckLogin(String U_name,String U_passworld);
	 public UserBean GetUserById(int U_id);
	 public int createHouse(HouseBean room);// 创建房间
	 public HouseBean getHouseById(Integer id);
		
	 public int updateHouse(HouseBean room);// 更新房间信息

	 int deleteHouse (Integer id);	// 删除房间
}
