package com.harin.t0902.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	/*
	 * 시 작 화 면
	 */
	@GetMapping("/")
	public String startHtml() {
		System.out.println("화면 시작");
		return "home";
	}

	/*
	 * 로 그 아 웃
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
