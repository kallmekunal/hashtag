package com.kunal.project.controller.domain.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.project.controller.domain.db.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	
//	@Autowired
	 private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUserInfo(UserInfo uerInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(uerInfo);
	}

	@Override
	public List<UserInfo> listUserInfo() {
		return (List<UserInfo>) sessionFactory.getCurrentSession().createCriteria(UserInfo.class).list();
	}

	@Override
	public UserInfo getUserInfo(int userid) {
		 return (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, userid);
		 
	}

	@Override
	public void deleteUserInfo(UserInfo userinfo) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+userinfo.getId()).executeUpdate();
	}

}
