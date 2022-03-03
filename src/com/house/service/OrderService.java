package com.house.service;

import java.util.List;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;
import com.house.common.utils.Page;

public interface OrderService {
	public Page<HouseBean> findHouseList(Integer page, Integer rows, 
            Integer R_id,Integer R_state);
	public List<ClassBean> findHouseClass();
	public int createHouse(HouseBean room);// ��������
	public HouseBean getHouseById(Integer id);
	
	public int updateHouse(HouseBean room);// ���·�����Ϣ

	int deleteHouse (Integer id);	// ɾ������
}
