package com.harin.t0902.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harin.t0902.mapper.UserMapper;
import com.harin.t0902.vo.UserVO;

@Service
public class UserLoginService implements UserLoginServiceI {
	
	@Autowired
	UserMapper um;
	
	/* 사 용 자 추 가
	 * */
	public HashMap<String,Object> addUser(UserVO uv) {
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		int checkId = um.selectAllUser(uv);
		if(checkId ==1) {
			returnMap.put("message",uv.getUsername()+"란 아이디가 이미 존재합니다!");
			returnMap.put("secStatus","400");
			return returnMap;
		}
		int result = um.insertNewUser(uv);
		/*
		 *  예외처리 보완 필요 => select > insert 로 변경 // 1단 수정완료
		 * */
		if(result == 1) {
			returnMap.put("message",uv.getUsername()+"으로 회원가입 되셨습니다!");
			returnMap.put("secStatus","200");
		}else {
			returnMap.put("message",uv.getUsername()+"으로 회원가입이 실패했습니다!");
			returnMap.put("secStatus","400");
		}
		return returnMap;
	}
	/* 사 용 자 검 증
	 * */
	public HashMap<String,Object> checkUser(UserVO uv,HttpSession session) {
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		int checkId = um.loginUserInfoCheck(uv);
		if(checkId !=1) {
			returnMap.put("message", "ID, 또는 password 불 일 치");
			returnMap.put("secStatus", "400");
			return returnMap;
		}
		System.out.println("checkId =="+checkId);
		returnMap.put("message",uv.getUsername()+"으로 로그인 완료!");
		returnMap.put("secStatus","222");
		session.setAttribute("user", uv.getUsername());
		return returnMap;
	}
}
