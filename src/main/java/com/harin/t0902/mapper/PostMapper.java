package com.harin.t0902.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.harin.t0902.vo.PostVO;

@Mapper
public interface PostMapper {
	public List<PostVO> getData();
	
	public int insertT(PostVO pb);
	
	public int updateT(PostVO pb);
	
	public int deleteT(PostVO pb);
	
}
