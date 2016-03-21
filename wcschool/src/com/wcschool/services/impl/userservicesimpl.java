package com.wcschool.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcschool.dao.userdao;
import com.wcschool.model.Userinfo;
import com.wcschool.services.userservice;
@Service("userservices")
public class userservicesimpl implements userservice{    
    private List<?> list ;
    @Autowired
	private userdao userDao;
	
	public void save(Userinfo user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	public userdao getUserDao() {
		return userDao;
	}
	public void setUserDao(userdao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		list = userDao.login(username, password);
		if  (list.size()>0)
		{
			return true ;
		}
		else
		{
		return false;
		}
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}

}
