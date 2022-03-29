package com.house.dao;

import java.util.List;

import com.house.bean.OrderBean;



public interface OrderDao {
	public List<OrderBean> selectOrderList(OrderBean OrderBean);//返回list合集
	public Integer selectOrderListCount(OrderBean OrderBean);//同计总行数
	
	public int createOrder(OrderBean room);// 创建房间
	public OrderBean getOrderById(Integer id);
	
	public int updateOrder(OrderBean order);// 更新房间信息

	int deleteOrder (Integer id);	// 删除房间
}
