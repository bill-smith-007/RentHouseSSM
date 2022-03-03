package com.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.house.bean.ClassBean;
import com.house.bean.HouseBean;
import com.house.bean.UserBean;
import com.house.common.utils.Help;
import com.house.common.utils.Page;
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

	@RequestMapping("/user/create.action")
	@ResponseBody
	public String createUser(String U_name, Integer U_root, String U_introduce, String U_password) {
		UserBean user = new UserBean();

		user.setU_name(U_name);
		user.setU_root(U_root);
		user.setU_introduce(U_introduce);
		user.setU_password(U_password);

		int rows = service.createUser(user);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/user/getUserById.action")
	@ResponseBody
	public UserBean getUserById(Integer id) {
		UserBean user = service.GetUserById(id);
		return user;
	}

	/**
	 * 更新员工
	 */
	@RequestMapping("/user/update.action")
	@ResponseBody
	public String userUpdate(Integer U_id, String U_name, Integer U_root, String U_introduce, String U_password) {

		UserBean user = new UserBean();
		user.setU_id(U_id);
		user.setU_name(U_name);
		user.setU_root(U_root);
		user.setU_introduce(U_introduce);
		user.setU_password(U_password);
		int rows = service.updateUser(user);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 删除员工
	 */
	@RequestMapping("/user/delete.action")
	@ResponseBody
	public String userDelete(Integer id) {
		int rows = service.deleteUser(id);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	@RequestMapping(value = "/user/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Integer U_id,String U_name,
			Model model) {
		// 条件查询所有的
		Page<UserBean> rooms=service.findUserList(page, rows, U_id,U_name);
		
		model.addAttribute("page", rooms);
		
		
		model.addAttribute("U_id", U_id);
		model.addAttribute("U_name", U_name);
		
		return "user";
	}
}
