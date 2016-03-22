package com.wcschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcschool.model.Userinfo;
import com.wcschool.services.impl.userservicesimpl;

@Controller

public class userController {
     
	private String username;
	private String password;
	 @Autowired
	 @Qualifier("userservices")
	private userservicesimpl userservimpl;
	@RequestMapping("/login")
	public String login()
	{
		Userinfo user =new Userinfo();
		user.setUsername("123");
		user.setPassword("123");
		boolean flag =userservimpl.login(username, password);
		if(flag == true)
		{
			return "Home_Page";
		}
		
		else
		{
			return "ssf";
		}
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public userservicesimpl getUserservimpl() {
		return userservimpl;
	}
	public void setUserservimpl(userservicesimpl userservimpl) {
		this.userservimpl = userservimpl;
	}
}
