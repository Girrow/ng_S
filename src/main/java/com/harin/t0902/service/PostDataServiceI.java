package com.harin.t0902.service;

import java.util.HashMap;
import java.util.List;

import com.harin.t0902.vo.PostVO;

public interface PostDataServiceI {
	public List<PostVO> getData();
	public HashMap<String, Object> crudExceptR(PostVO pv, String branch);
}
