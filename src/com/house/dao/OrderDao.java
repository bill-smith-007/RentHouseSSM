package com.house.dao;

import java.util.List;

import com.house.bean.OrderBean;



public interface OrderDao {
	public List<OrderBean> selectOrderList(OrderBean OrderBean);//����list�ϼ�
	public Integer selectOrderListCount(OrderBean OrderBean);//ͬ��������
	
	public int createOrder(OrderBean room);// ��������
	public OrderBean getOrderById(Integer id);
	
	public int updateOrder(OrderBean order);// ���·�����Ϣ

	int deleteOrder (Integer id);	// ɾ������
}
