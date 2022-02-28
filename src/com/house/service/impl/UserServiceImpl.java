package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.bean.HouseBean;
import com.house.bean.UserBean;
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
	@Override
	public UserBean GetUserById(int U_id) {
		UserBean user=userDao.getUserById(U_id);
		return user;
	}
	@Override
	public int createHouse(HouseBean room) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public HouseBean getHouseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateHouse(HouseBean room) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteHouse(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
