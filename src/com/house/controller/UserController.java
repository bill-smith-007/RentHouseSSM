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
	@RequestMapping(value="/logincheck.action" , method = RequestMethod.POST)
    public String adminAccess(HttpServletRequest request,String name,String pass) {
	 // ModelAndView mv = new ModelAndView();
		//boolean check=false;
		System.out.println(name);
		System.out.println(pass);
		
		try {
			Integer check=service.CheckLogin(name, pass);
			 if (check != null){
				 
		    	  return "redirect:/NewFile.jsp";
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//System.out.println(check==true?"666":"something is wrong");
      
    
		
	
		
     return "dssd";
      //request.setAttribute("itemList", tString);
     // return "itemList";
      }
    }

