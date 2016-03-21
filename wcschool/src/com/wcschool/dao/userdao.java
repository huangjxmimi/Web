package com.wcschool.dao;



import java.util.List;

import com.wcschool.model.Userinfo;


public interface userdao {
       
	public void save(Userinfo user);
	public List<Userinfo>  login(String username,String password);
	public Userinfo getUserBYID(int userid);
	public void delete (Userinfo user);
	public void update (Userinfo user);
}
