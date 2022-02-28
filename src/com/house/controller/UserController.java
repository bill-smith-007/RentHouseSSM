package com.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.house.bean.HouseBean;
import com.house.bean.UserBean;
import com.house.common.utils.Help;
import com.house.dao.UserDao;
import com.house.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	/*
	
	 */
	@RequestMapping(value = "/logincheck.action", method = RequestMethod.POST)
	public String adminAccess(String name, String pass, Model model, HttpSession session) {
		// ModelAndView mv = new ModelAndView();
		// boolean check=false;
		Integer check = service.CheckLogin(name, pass);
		if (check != null) {

			UserBean userBean = service.GetUserById(check);
			Help.localuser = userBean;
			session.setAttribute("USER_SESSION", userBean);
			// System.out.println(Help.localuser.getU_introduce());
			return "redirect:house/list.action";
		}

		// System.out.println(check==true?"666":"something is wrong");

		return "dssd";
		// request.setAttribute("itemList", tString);
		// return "itemList";
	}
	@RequestMapping("/house/create.action")
	@ResponseBody
	public String createHouse(Integer R_id,String R_name,Integer R_class_id,String R_introduce,Double R_price) {
		HouseBean house=new HouseBean();
		house.setR_id(R_id);
		house.setR_name(R_name);
		house.setR_state(0);
		house.setR_create_id(Help.localuser.getU_id());
		house.setR_class_id(R_class_id);
		house.setR_introduce(R_introduce);
		house.setR_price(R_price);
		house.setR_ceate_time(Help.gDate());
	    int rows = houseService.createHouse(house);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/house/getRoomById.action")
	@ResponseBody
	public HouseBean getRoomById(Integer id) {
		HouseBean house = houseService.getHouseById(id);
	    return house;
	}
	/**
	 * 更新员工
	 */
	@RequestMapping("/house/update.action")
	@ResponseBody
	public String roomUpdate(Integer R_id,String R_name,Integer R_class_id,Integer R_state,String R_introduce,Double R_price) {
		Integer a;
		a=11;
		int aa=11;
		System.out.println(aa==a);
		System.out.println(a.equals(aa));
		HouseBean house=new HouseBean();
		house.setR_id(R_id);
		house.setR_name(R_name);
		house.setR_state(R_state);
		house.setR_class_id(R_class_id);
		house.setR_introduce(R_introduce);
		house.setR_price(R_price);
		house.setR_ceate_time(Help.gDate());
	    int rows = houseService.updateHouse(house);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除员工
	 */
	@RequestMapping("/house/delete.action")
	@ResponseBody
	public String roomDelete(Integer id) {
	    int rows = houseService.deleteHouse(id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
}
