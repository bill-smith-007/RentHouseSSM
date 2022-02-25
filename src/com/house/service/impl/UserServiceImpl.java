package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.dao.UserDao;
import com.house.service.UserService;
@Service("userService")

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public Integer CheckLogin(String U_name,String U_passworld) {
		System.out.println(U_name);System.out.println(U_passworld);
		
			if (userDao.CheckLogin(U_name,U_passworld) != null) {
				return 1;
			
		} 
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
