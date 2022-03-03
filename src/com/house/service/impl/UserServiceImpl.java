package com.house.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.house.bean.UserBean;
import com.house.common.utils.Page;
import com.house.dao.UserDao;
import com.house.service.UserService;

@Service("userService")

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Integer CheckLogin(String U_name, String U_passworld) {

		if (userDao.CheckLogin(U_name, U_passworld) != null) {
			return 1;

		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean GetUserById(Integer U_id) {
		UserBean user = userDao.getUserById(U_id);
		return user;
	}

	@Override
	public int createUser(UserBean user) {
		// TODO Auto-generated method stub
		return userDao.createUser(user);
	}

	@Override
	public int updateUser(UserBean user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public Page<UserBean> findUserList(Integer page, Integer rows, Integer U_id,String U_name) {
		// 创建员工对象
				UserBean user=new UserBean();
		        
				// 判断员工名称
				if(StringUtils.isNotBlank(U_id+"")){
					user.setU_id(U_id);
				}
				// 判断员工工号
				if(StringUtils.isNotBlank(U_name+"")){
					user.setU_name(U_name);
					}
				
				// 当前页
				user.setStart((page-1) * rows) ;
				// 每页数
				user.setRows(rows);
				// 查询员工列表
				List<UserBean> users = userDao.selectUserList(user);
				// 查询员工列表总记录数
				Integer count = userDao.selectUserListCount(user) ;
				// 创建Page返回对象
				Page<UserBean> result = new Page<>();
				result.setPage(page);
				result.setRows(users);
				result.setSize(rows);
				result.setTotal(count);
				return result;
	}

}
