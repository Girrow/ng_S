package com.harin.t0902.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.harin.t0902.vo.UserVO;

public interface UserLoginServiceI {
	public HashMap<String,Object> addUser(UserVO uv);
	public HashMap<String,Object> checkUser(UserVO uv,HttpSession session);
}
