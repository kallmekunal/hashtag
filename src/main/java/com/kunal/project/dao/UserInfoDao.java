package com.kunal.project.dao;
import java.util.List;

import com.kunal.project.db.UserInfo;

public interface UserInfoDao {
 
 public void addUserInfo(UserInfo uerInfo);

 public List<UserInfo> listUserInfo();
 
 public UserInfo getUserInfo(int userid);
 
 public void deleteUserInfo(UserInfo userinfo);
}