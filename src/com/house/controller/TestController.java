package com.house.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;



import com.house.service.TestService;

@Controller
public class TestController {
	
	@Autowired
    private TestService service;
    
/*
 * ≤‚ ‘”√¿˝◊”
 */
	@GetMapping(value="/test.action")
	@ResponseBody
    public String adminAccess(HttpServletRequest request) {
	 // ModelAndView mv = new ModelAndView();
		
      String tString=service.GetRes();
      System.out.println(tString);
     

      return tString;
      //request.setAttribute("itemList", tString);
     // return "itemList";
      }
    }

