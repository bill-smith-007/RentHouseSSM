package com.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.house.bean.UserBean;

public interface UserDao {
	public Integer CheckLogin(@Param("U_name")String U_name,@Param("U_password")String U_password);
	public UserBean getUserById(Integer U_id);
	public int createUser(UserBean room);// 创建房间
	
	public List<UserBean> selectUserList(UserBean UserBean);//返回list合集
	public Integer selectUserListCount(UserBean UserBean);//同计总行数
	
	
	public int updateUser(UserBean room);// 更新房间信息

	int deleteUser (Integer id);	// 删除房间
}
