package com.wcschool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wcschool.dao.userdao;
import com.wcschool.model.Userinfo;














import org.springframework.stereotype.Repository;
@Repository

public class userdaoimpl extends HibernateDaoSupport implements userdao{
       
	private List<Userinfo> resultList;
	@Override
	public void save(Userinfo user) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(user);
	}
	@Resource(name = "sessionFactory")  
	private void setHibernateSessionFactory(SessionFactory sessionFactory) {  
	    // 这个方法名可以随便写，@Resource可以通过name 或者type来装载的。  
	    super.setSessionFactory(sessionFactory);  
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> login(final String username,final String password) {
		
		return (List<Userinfo>) super.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) 
					throws HibernateException{
				// TODO Auto-generated method stub
				String hql="select u from Userinfo as u where u.username=:username and u.password=:password";
				Query query=session.createQuery(hql);
				query.setString("username", username);
				query.setString("password", password);
				resultList =query.list();
			    return resultList;
			}
			
		});	
	}
	@Override
	public Userinfo getUserBYID(final int userid) {
		// TODO Auto-generated method stub
		return (Userinfo) super.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql="select u from Userinfo as u where u.id=:id";
				Query query=session.createQuery(hql);
				query.setInteger("id", userid);
				return (Userinfo)query.uniqueResult();
			}
		});
	}
	@Override
	public void delete(Userinfo user) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().delete(user);
	}
	@Override
	public void update(Userinfo user) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(user);
	}  
	public List<Userinfo> getResultList() {
		return resultList;
	}
	public void setResultList(List<Userinfo> resultList) {
		this.resultList = resultList;
	}
}
