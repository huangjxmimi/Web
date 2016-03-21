package com.wcschool.services;

import com.wcschool.model.Userinfo;


public interface userservice {
        public void save(Userinfo user);
        public boolean login(String username,String password);
}
