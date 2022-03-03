package com.house.dao;

import java.util.List;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;



public interface OrderDao {
	public List<HouseBean> selectHouseList(HouseBean HouseBean);//返回list合集
	public Integer selectHouseListCount(HouseBean HouseBean);//同计总行数
	public List<ClassBean> findHouseClass();//返回list合集
	public int createHouse(HouseBean room);// 创建房间
	public HouseBean getHouseById(Integer id);
	
	public int updateHouse(HouseBean room);// 更新房间信息

	int deleteHouse (Integer id);	// 删除房间
}
