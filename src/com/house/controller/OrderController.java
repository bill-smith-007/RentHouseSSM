package com.house.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;
import com.house.bean.OrderBean;
import com.house.bean.UserBean;
import com.house.common.utils.Help;
import com.house.common.utils.Page;
import com.house.service.HouseService;
import com.house.service.OrderService;

import javafx.beans.DefaultProperty;

@Controller
public class OrderController {
	// 依赖注入
	@Autowired
	private OrderService orderService;
	@Autowired
	private HouseService houseService;

	/**
	 * 房间的列表
	 */
	@RequestMapping(value = "/order/list.action")
	public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows,
			Integer M_id, Integer M_state, Model model) {
		// 条件查询所有的
		Page<OrderBean> rooms = orderService.findOrderList(page, rows, M_id, M_state);

		model.addAttribute("page", rooms);

		model.addAttribute("M_id", M_id);
		model.addAttribute("M_state", M_state);

		return "order";
	}

	/**
	 * R_id, R_name, R_state, R_class_id, R_introduce, R_price, R_create_id,
	 * R_ceate_time
	 */
	@RequestMapping("/order/create.action")
	@ResponseBody
	public String createOrder(Integer R_id, String R_name, Integer R_class_id, String R_introduce, Double R_price) {
		OrderBean order = new OrderBean();

		int rows = orderService.createOrder(order);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/order/getOrderById.action")
	@ResponseBody
	public OrderBean getOrderById(Integer id) {
		OrderBean order = orderService.getOrderById(id);
		return order;
	}

	/**
	 * 更新员工
	 */
	@RequestMapping("/order/update.action")
	@ResponseBody
	public String roomUpdate(Integer M_id, Integer M_time) {

		OrderBean order = new OrderBean();

		order.setM_id(M_id);
		order.setM_time(M_time);
		System.out.println(M_time);
		int rows = orderService.updateOrder(order);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 删除 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	 */
	@RequestMapping("/order/delete.action")
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String roomDelete(Integer m_id, Integer r_id) throws Exception {
		int rows = orderService.deleteOrder(m_id);

		if (rows > 0) {
			HouseBean houseBean = new HouseBean();
			houseBean.setR_id(r_id);
			houseBean.setR_state(0);

			int res = houseService.updateHouse(houseBean);
			if (res > 0) {

				return "OK";
			} else {
				return "FAIL";
			}
		} else {
			return "FAIL";
		}

	}

	@RequestMapping("/order/newBook.action")
	@ResponseBody
	@Transactional 
	public String roomBook(Integer R_id, Double R_price, String M_time_order, Integer M_time, HttpSession session) {
		String result = "";
		UserBean user = (UserBean) session.getAttribute("USER_SESSION");
		System.out.println(R_price);
		System.out.println(M_time);
		OrderBean order = new OrderBean();

		order.setU_id(user.getU_id());
		order.setR_id(R_id);
		System.out.println(M_time_order);
		//
		//由于前端date传过来的是String类型的数据，想要转存需要格式转换
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
	     try {
			Date date = simpleDateFormat.parse(M_time_order);
			order.setM_time_order(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setM_people(user.getU_name());
		order.setM_time(M_time);
		order.setM_money(R_price * M_time);
		int rows_test=orderService.createOrder(order);
		//上述操作完成order的创建
		HouseBean houseBean=new HouseBean();
		houseBean.setR_id(R_id);
		houseBean.setR_state(1);
		int rows_change=houseService.updateHouse(houseBean);
		
		if (rows_test > 0) {
			if (rows_change>0) {
				result = "OK";
			}
			else {
				throw new RuntimeException();  
				//回滚测试
			}
		} else {
			result = "FAIL";
		}
		return result;

	}

}
