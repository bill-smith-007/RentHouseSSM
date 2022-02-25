package com.house.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import com.house.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService service;
    
/*
 * ≤‚ ‘”√¿˝◊”
 */
	@GetMapping(value="/logincheck.action")
	@ResponseBody
    public String adminAccess(HttpServletRequest request,String name,String pass) {
	 // ModelAndView mv = new ModelAndView();
		//boolean check=false;
		System.out.println(name);
		System.out.println(pass);
		/*
		try {
			check=service.CheckLogin(name, pass);

		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		//System.out.println(check==true?"666":"something is wrong");
      
     if (service.CheckLogin(name, pass) != null){
    	  return "redirect:/NewFile.jsp";
		}
		
	
		
     return "dssd";
      //request.setAttribute("itemList", tString);
     // return "itemList";
      }
    }

