package com.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
}
