package com.house.service;

import com.house.bean.HouseBean;
import com.house.bean.UserBean;

public interface UserService {
	 Integer CheckLogin(String U_name,String U_passworld);
	 public UserBean GetUserById(int U_id);
	 public int createHouse(HouseBean room);// ��������
	 public HouseBean getHouseById(Integer id);
		
	 public int updateHouse(HouseBean room);// ���·�����Ϣ

	 int deleteHouse (Integer id);	// ɾ������
}
