package com.house.dao;

import java.util.List;

import com.house.bean.HouseBean;



public interface HouseDao {
	public List<HouseBean> selectHouseList(HouseBean HouseBean);
	public Integer selectHouseListCount(HouseBean HouseBean);
}
