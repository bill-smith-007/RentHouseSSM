package com.house.service;


import com.house.bean.OrderBean;
import com.house.common.utils.Page;

public interface OrderService {
	public Page<OrderBean> findOrderList(Integer page, Integer rows, 
            Integer M_id,Integer M_state);

	public int createOrder(OrderBean Order);
	public OrderBean getOrderById(Integer id);
	
	public int updateOrder(OrderBean order);

	int deleteOrder (Integer id);
}
