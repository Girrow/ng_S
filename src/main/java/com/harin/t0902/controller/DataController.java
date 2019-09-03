package com.harin.t0902.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harin.t0902.service.PostDataService;
import com.harin.t0902.service.UserLoginService;
import com.harin.t0902.vo.PostVO;
import com.harin.t0902.vo.UserVO;

@RestController
public class DataController {

	@Autowired
	UserLoginService uls;

	@Autowired
	PostDataService pds;

	/*
	 * C R U D
	 */
	
	@PostMapping("/getPostData")
	public List<PostVO> getPostData() {
		List<PostVO> resultList = pds.getData();
		return resultList;
	}

	@PostMapping("/crud/{branch}")
	public HashMap<String, Object> test(@Valid PostVO pv, BindingResult bindResult, HttpSession session,@PathVariable String branch) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = checkValidation(resultMap, bindResult);
		if ("200".equals(resultMap.get("status").toString())) {

			if (session.getAttribute("user") != null) {
				pv.setWriter(session.getAttribute("user").toString());
				System.out.println("PostVo pv =" + pv.toString());
				resultMap = pds.crudExceptR(pv, branch);
			} else {
				resultMap.put("status", "400");
				resultMap.put("comment", "로그인 되어있지 않습니다.");
			}
		}
		return resultMap;
	}
	
	
	/* *
	 * 로그인 부분 
	 * */

	/*
	 * 회 원 가 입
	 */
	@PostMapping("/addUser")
	public HashMap<String, Object> addUser(@Valid UserVO uv, BindingResult bindResult, HttpSession session) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = checkValidation(resultMap, bindResult);
		if ("200".equals(resultMap.get("status").toString())) {
			resultMap.put("returnInfo", uls.addUser(uv));
		}
		return resultMap;
	}

	/*
	 * 로 그 인
	 */
	@PostMapping("/login")
	public HashMap<String, Object> checkUser(@Valid UserVO uv, BindingResult bindResult, HttpSession session) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = checkValidation(resultMap, bindResult);
		if ("200".equals(resultMap.get("status").toString())) {
			resultMap.put("returnInfo", uls.checkUser(uv, session));
		}
		return resultMap;
	}
	
	/*
	 * Validation Method 처리
	 * */
	public HashMap<String, Object> checkValidation(HashMap<String, Object> returnMap, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
			List<ObjectError> errors = bindResult.getAllErrors();
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : errors) {
				System.out.printf("error :%s : %s", error.getCode(), error.getDefaultMessage());
				System.out.println("");
				errorList.add(error.getDefaultMessage());
			}
			returnMap.put("status", 400);
			returnMap.put("comment", errorList);
			return returnMap;
		} else {
			returnMap.put("status", 200);
			return returnMap;
		}
	}
}
