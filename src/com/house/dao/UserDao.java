package com.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.house.bean.UserBean;

public interface UserDao {
	public Integer CheckLogin(@Param("U_name")String U_name,@Param("U_password")String U_password);
	public UserBean getUserById(Integer U_id);
	public int createUser(UserBean room);// ��������
	
	public List<UserBean> selectUserList(UserBean UserBean);//����list�ϼ�
	public Integer selectUserListCount(UserBean UserBean);//ͬ��������
	
	
	public int updateUser(UserBean room);// ���·�����Ϣ

	int deleteUser (Integer id);	// ɾ������
}
