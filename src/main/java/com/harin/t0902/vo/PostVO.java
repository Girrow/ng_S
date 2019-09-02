package com.harin.t0902.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter @Setter
public class PostVO {
	private String pno;
	@NotBlank
	private String comment;
	private String writer;
}
