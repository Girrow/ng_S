package com.harin.t0902.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.harin.t0902.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public int selectAllUser(UserVO uv);
	
	public int insertNewUser(UserVO uv);
	
	public int loginUserInfoCheck(UserVO uv);
}
