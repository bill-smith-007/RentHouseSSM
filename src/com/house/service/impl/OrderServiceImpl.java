package com.house.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.house.bean.ClassBean;
import com.house.bean.OrderBean;
import com.house.common.utils.Page;
import com.house.dao.OrderDao;
import com.house.service.OrderService;



@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Override
	public Page<OrderBean> findOrderList(Integer page, Integer rows, Integer R_id, Integer R_state) {
		
		// 创建员工对象
		OrderBean order=new OrderBean();
        
		// 判断员工名称
		if(StringUtils.isNotBlank(R_id+"")){
			order.setR_id(R_id);
		}
		
		// 当前页
		order.setStart((page-1) * rows) ;
		// 每页数
		order.setRows(rows);
		// 查询员工列表
		List<OrderBean> orders = orderDao.selectOrderList(order);
		// 查询员工列表总记录数
		Integer count = orderDao.selectOrderListCount(order) ;
		// 创建Page返回对象
		Page<OrderBean> result = new Page<>();
		result.setPage(page);
		result.setRows(orders);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	
	@Override
	public int createOrder(OrderBean Order) {
		return orderDao.createOrder(Order);
	}
	@Override
	public OrderBean getOrderById(Integer id) {
		return orderDao.getOrderById(id);
	}
	@Override
	public int updateOrder(OrderBean Order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(Order);
	}
	@Override
	public int deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(id);
	}
}
