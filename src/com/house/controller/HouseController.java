package com.house.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;
import com.house.common.utils.Help;
import com.house.common.utils.Page;
import com.house.service.HouseService;

import javafx.beans.DefaultProperty;



@Controller
public class HouseController {
	// 依赖注入
	@Autowired
	private HouseService houseService;
	
	
	/**
	 *  房间的列表
	 */
	@RequestMapping(value = "/house/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Integer R_id,Integer R_state,
			Model model) {
		// 条件查询所有的
		Page<HouseBean> rooms=houseService.findHouseList(page, rows, R_id,R_state );
		List<ClassBean> classes=houseService.findHouseClass();
		model.addAttribute("page", rooms);
		model.addAttribute("classes",classes);
		
		model.addAttribute("R_id", R_id);
		model.addAttribute("R_state", R_state);
		
		return "room";
	}
	
	/**
	 R_id,
		R_name,
		R_state,
		R_class_id,
		R_introduce,
		R_price,
		R_create_id,
		R_ceate_time
	 */
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
//	@RequestMapping("/room/newBook.action")
//	@ResponseBody
//	public String roomBook(Integer R_id,Integer R_price,String B_data,Integer B_time, HttpSession session) {
//		String result="";
//		User user=(User) session.getAttribute("USER_SESSION");
//		
//	    Book book=new Book();
//	    book.setR_id(R_id);
//	    //System.out.println(Help.local_user.getId());
//	    book.setQ_id(user.getId());
//	    book.setB_take(Double.valueOf(B_time));
//	    book.settime(B_data);
//	    book.setcreate(Help.getTime());
//	    
//	    Money money=new Money();
//	    money.setQ_id(user.getId());
//	    money.setM_count(Double.valueOf(R_price*B_time));
//	    money.setR_id(R_id);
//	    money.setM_state(0);
//	    money.settime(Help.getTime());
//		int rows_test = houseService.changeRoomState(R_id);
//	    if(rows_test > 0){
//	    	 int rows_step1 = houseService.createbook(book);
//	    	 if(rows_step1 > 0){
//	    		 int rows_step2 = houseService.createmoney(money);
//	    		 if(rows_step2 > 0)  {result= "OK";};	
//	    	 }
//	        
//	    }else{
//	    	result= "FAIL";			
//	    }
//		return result;
//		
//	}
	   
}
