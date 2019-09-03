package com.harin.t0902.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harin.t0902.mapper.PostMapper;
import com.harin.t0902.vo.PostVO;

@Service
public class PostDataService implements PostDataServiceI {

	@Autowired
	PostMapper pm;

	public List<PostVO> getData() {
		return pm.getData();
	}

	public HashMap<String, Object> crudExceptR(PostVO pv, String branch) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {

			switch (branch) {
			case "insert":
				resultMap = insertData(resultMap, pv);
				break;
			case "update":
				resultMap = updateData(resultMap, pv);
				break;
			case "delete":
				resultMap = deleteData(resultMap, pv);
				break;
			default:
				resultMap.put("status", "400");
				resultMap.put("comment", "정의하지 않은 메소드입니다.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "401");
			resultMap.put("comment", "DB 오류");
		}
		return resultMap;
	}

	/*
	 * Method로 묶기 // 09/03 3시여서 포기함
	 */
	public HashMap<String, Object> insertData(HashMap<String, Object> resultMap, PostVO pv) throws SQLException {
		int result = pm.insertT(pv);
		if (result == 1) {
			resultMap.put("status", "200");
			resultMap.put("comment", "추가 성공");
		} else {
			resultMap.put("status", "400");
			resultMap.put("comment", "추가 실패! insert 오류 발생");
		}
		return resultMap;
	}

	public HashMap<String, Object> updateData(HashMap<String, Object> resultMap, PostVO pv) throws SQLException {
		int result = pm.updateT(pv);
		if (result == 1) {
			resultMap.put("status", "200");
			resultMap.put("comment", "수정 성공");
		} else {
			resultMap.put("status", "400");
			resultMap.put("comment", "추가 실패! update 오류 발생// ID가 일치하지 않습니다");
		}
		return resultMap;
	}

	public HashMap<String, Object> deleteData(HashMap<String, Object> resultMap, PostVO pv) throws SQLException {
		int result = pm.deleteT(pv);
		if (result == 1) {
			resultMap.put("status", "200");
			resultMap.put("comment", "삭제 성공");
		} else {
			resultMap.put("status", "400");
			resultMap.put("comment", "삭제 실패! delete 오류 발생 // ID가 일치하지 않습니다");
		}
		return resultMap;
	}

}
