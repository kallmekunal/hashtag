package com.kunal.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kunal.project.controller.domain.dao.UserInfoDao;
import com.kunal.project.controller.domain.db.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	@Transactional
	public void addUserInfo(UserInfo uerInfo) {
		userInfoDao.addUserInfo(uerInfo);
	}

	@Override
	@Transactional
	public List<UserInfo> listUserInfo() {
		return userInfoDao.listUserInfo();
	}

	@Override
	@Transactional
	public UserInfo getUserInfo(int userid) {
		return userInfoDao.getUserInfo(userid);
	}

	@Override
	@Transactional
	public void deleteUserInfo(UserInfo userinfo) {
		userInfoDao.deleteUserInfo(userinfo);
	}

}
