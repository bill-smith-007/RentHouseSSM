package com.house.service;

import com.house.bean.HouseBean;
import com.house.common.utils.Page;

public interface HouseService {
	public Page<HouseBean> findHouseList(Integer page, Integer rows, 
            Integer R_id,Integer R_state);
}
