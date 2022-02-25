package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.dao.TestDao;
import com.house.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	@Override
	public String GetRes() {
		// TODO Auto-generated method stub
		String reString=testDao.GetRes();
		return reString;
	}

}
