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
		
		// ����Ա������
		OrderBean order=new OrderBean();
        
		// �ж�Ա������
		if(StringUtils.isNotBlank(R_id+"")){
			order.setR_id(R_id);
		}
		
		// ��ǰҳ
		order.setStart((page-1) * rows) ;
		// ÿҳ��
		order.setRows(rows);
		// ��ѯԱ���б�
		List<OrderBean> orders = orderDao.selectOrderList(order);
		// ��ѯԱ���б��ܼ�¼��
		Integer count = orderDao.selectOrderListCount(order) ;
		// ����Page���ض���
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
