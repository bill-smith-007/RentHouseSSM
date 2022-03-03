package com.house.dao;

import java.util.List;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;



public interface OrderDao {
	public List<HouseBean> selectHouseList(HouseBean HouseBean);//����list�ϼ�
	public Integer selectHouseListCount(HouseBean HouseBean);//ͬ��������
	public List<ClassBean> findHouseClass();//����list�ϼ�
	public int createHouse(HouseBean room);// ��������
	public HouseBean getHouseById(Integer id);
	
	public int updateHouse(HouseBean room);// ���·�����Ϣ

	int deleteHouse (Integer id);	// ɾ������
}
