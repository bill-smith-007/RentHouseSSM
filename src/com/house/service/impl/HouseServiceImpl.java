package com.house.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.bean.HouseBean;
import com.house.common.utils.Page;
import com.house.dao.HouseDao;
import com.house.service.HouseService;



@Service("houseService")
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;
	@Override
	public Page<HouseBean> findHouseList(Integer page, Integer rows, Integer R_id, Integer R_state) {
		
		// ����Ա������
		HouseBean house=new HouseBean();
        
		// �ж�Ա������
		if(StringUtils.isNotBlank(R_id+"")){
			house.setR_id(R_id);
		}
		// �ж�Ա������
		if(StringUtils.isNotBlank(R_state+"")){
			house.setR_state(R_state);
		}
		
		// ��ǰҳ
		house.setStart((page-1) * rows) ;
		// ÿҳ��
		house.setRows(rows);
		// ��ѯԱ���б�
		List<HouseBean> houses = houseDao.selectHouseList(house);
		// ��ѯԱ���б��ܼ�¼��
		Integer count = houseDao.selectHouseListCount(house) ;
		// ����Page���ض���
		Page<HouseBean> result = new Page<>();
		result.setPage(page);
		result.setRows(houses);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	
}
