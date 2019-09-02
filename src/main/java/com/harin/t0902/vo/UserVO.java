package com.harin.t0902.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter @Setter
public class UserVO {
	
	private String userNo;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
}
