package com.kunal.project.service;
import java.util.List;

import com.kunal.project.controller.domain.db.UserInfo;

public interface UserInfoService {
 
 public void addUserInfo(UserInfo uerInfo);

 public List<UserInfo> listUserInfo();
 
 public UserInfo getUserInfo(int userid);
 
 public void deleteUserInfo(UserInfo userinfo);
}